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


    @GetMapping("/test")
    String  sayHello(){
        return "Hello from statistic";
    }

    /**
     curl -H "Content-Type: application/json" -X POST -d {\"userId\":1,\"pageId\":1}  http://localhost:8080/statistic/visit
     */
    @PostMapping("/visit")
    HttpEntity<CommonStatDto> getAssessList(@RequestBody PageVisitDto dto){
        log.info("VisitPageDto: "+dto);
        CommonStatDto result = pageVisitService.visitEvent(dto);
        return result != null ? ResponseEntity.ok(result) : ResponseEntity.badRequest().build();
    }

    /**
     curl -H "Content-Type: application/json" -X POST -d {\"start\":\"2020-07-21T00:00:00.000+00:00\",\"end\":\"2020-07-31T00:00:00.000+00:00\"}  http://localhost:8080/statistic/period
     */
    @PostMapping("/period")
    HttpEntity<PeriodStatDto> getAssessList(@RequestBody PeriodDto periodDto){
        log.info("PeriodDto: "+periodDto);
        PeriodStatDto result = pageVisitService.periodStat(periodDto);
        return result != null ? ResponseEntity.ok(result) : ResponseEntity.badRequest().build();
    }
}
