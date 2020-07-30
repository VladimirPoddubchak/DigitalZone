package com.poddubchak.testjob.DigitalZone.service;

import com.poddubchak.testjob.DigitalZone.dto.CommonStatDto;
import com.poddubchak.testjob.DigitalZone.dto.PageVisitDto;
import com.poddubchak.testjob.DigitalZone.dto.PeriodDto;
import com.poddubchak.testjob.DigitalZone.dto.PeriodStatDto;
import com.poddubchak.testjob.DigitalZone.model.PageVisit;
import com.poddubchak.testjob.DigitalZone.repo.PageVisitRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by @author Vladimir Poddubchak @date 29.07.2020.
 */

@Component
public class PageVisitServiceImpl implements PageVisitService{
    @Autowired
    PageVisitRepo pageVisitRepo;

    @Override
    public CommonStatDto visitEvent(PageVisitDto pageVisitDto) {
        pageVisitRepo.save(fromDto(pageVisitDto));
        return new CommonStatDto(pageVisitRepo.getTotalVisitByDay(),pageVisitRepo.getUniqueVisitByDay());
    }

    @Override
    public PeriodStatDto periodStat(PeriodDto periodDto) {
        Date start = periodDto.getStart();
        Date end = periodDto.getEnd();
        return new PeriodStatDto(pageVisitRepo.getTotalVisitByPeriod(start,end),
                                pageVisitRepo.getUniqueVisitByPeriod(start,end),
                                pageVisitRepo.getRegularVisitByPeriod(start,end));
    }

    @Override
    public PageVisit fromDto(PageVisitDto pageVisitDto) {
        return PageVisit.builder()
                .userId(pageVisitDto.getUserId())
                .pageId(pageVisitDto.getPageId())
                .visitDate(new Date())
                .build();
    }
}
