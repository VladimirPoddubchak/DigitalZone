package com.poddubchak.testjob.DigitalZone.service;

import com.poddubchak.testjob.DigitalZone.dto.CommonStatDto;
import com.poddubchak.testjob.DigitalZone.dto.PageVisitDto;
import com.poddubchak.testjob.DigitalZone.dto.PeriodDto;
import com.poddubchak.testjob.DigitalZone.dto.PeriodStatDto;
import com.poddubchak.testjob.DigitalZone.model.PageVisit;
import com.poddubchak.testjob.DigitalZone.repo.PageVisitRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

/**
 * Created by @author Vladimir Poddubchak @date 29.07.2020.
 */
@Slf4j
@Component
public class PageVisitServiceImpl implements PageVisitService{
    @Autowired
    PageVisitRepo pageVisitRepo;

    @Override
    @Transactional
    public CommonStatDto visitEvent(PageVisitDto pageVisitDto) {
        if (pageVisitDto==null||pageVisitDto.getUserId()==null||pageVisitDto.getPageId()==null){
            log.error("Wrong PageVisitDto argument: "+pageVisitDto);
            return null;
        }
        CommonStatDto result = null;

        try{
            pageVisitRepo.save(fromDto(pageVisitDto));
        }catch (DataAccessException e){
            log.error(e.toString());
            return null;
        }

        try{
            result = new CommonStatDto(pageVisitRepo.getTotalVisitByDay(),pageVisitRepo.getUniqueVisitByDay());
        }catch (DataAccessException e){
            log.error(e.toString());
            return null;
        }
        return result;
    }

    @Override
    public PeriodStatDto periodStat(PeriodDto periodDto) {

        if (periodDto==null||periodDto.getStart()==null||periodDto.getEnd()==null||periodDto.getStart().isAfter(periodDto.getEnd())){
            log.error("Wrong PeriodDto argument: "+periodDto);
            return null;
        }

        PeriodStatDto result = null;
        try {
            result = new PeriodStatDto(pageVisitRepo.getTotalVisitByPeriod(periodDto.getStart(), periodDto.getEnd()),
                    pageVisitRepo.getUniqueVisitByPeriod(periodDto.getStart(), periodDto.getEnd()),
                    pageVisitRepo.getRegularVisitByPeriod(periodDto.getStart(), periodDto.getEnd()));
        }catch (DataAccessException e){
            log.error(e.toString());
        }

        return result;
    }

    @Override
    public PageVisit fromDto(PageVisitDto pageVisitDto) {

        return PageVisit.builder()
                .userId(pageVisitDto.getUserId())
                .pageId(pageVisitDto.getPageId())
                .visitDate(LocalDateTime.now())
                .build();
    }
}
