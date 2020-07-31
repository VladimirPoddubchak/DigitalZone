package com.poddubchak.testjob.DigitalZone.controller;

import com.poddubchak.testjob.DigitalZone.dto.CommonStatDto;
import com.poddubchak.testjob.DigitalZone.dto.PageVisitDto;
import com.poddubchak.testjob.DigitalZone.dto.PeriodDto;
import com.poddubchak.testjob.DigitalZone.dto.PeriodStatDto;
import com.poddubchak.testjob.DigitalZone.service.PageVisitService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by @author Vladimir Poddubchak @date 29.07.2020.
 */
@RestController
@RequestMapping("/statistic")
@Slf4j
public class PageVisitController {

    @Autowired
    PageVisitService pageVisitService;

    /**
     curl -H "Content-Type: application/json" -X POST -d {\"userId\":1,\"pageId\":1}  http://localhost:8080/statistic/visit
     */
    @PostMapping("/visit")
    HttpEntity<CommonStatDto> visitEvent(@RequestBody PageVisitDto dto){
        log.info("VisitPageDto: "+dto);
        CommonStatDto result = pageVisitService.visitEvent(dto);
        log.info("result: "+result);
        return result != null ? ResponseEntity.ok(result) : ResponseEntity.badRequest().build();
    }

    /**
     curl -H "Content-Type: application/json" -X POST -d {\"start\":\"2020-07-30T18:23:01.225\",\"end\":\"2020-07-31T00:00:00.000\"}  http://localhost:8080/statistic/period
     */
    @PostMapping("/period")
    HttpEntity<PeriodStatDto> getStatistic(@RequestBody PeriodDto periodDto){
        log.info("PeriodDto: "+periodDto);
        PeriodStatDto result = pageVisitService.periodStat(periodDto);
        log.info("result: "+result);
        return result != null ? ResponseEntity.ok(result) : ResponseEntity.badRequest().build();
    }
}
