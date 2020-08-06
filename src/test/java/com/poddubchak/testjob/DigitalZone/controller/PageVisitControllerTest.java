package com.poddubchak.testjob.DigitalZone.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.poddubchak.testjob.DigitalZone.dto.CommonStatDto;
import com.poddubchak.testjob.DigitalZone.dto.PageVisitDto;
import com.poddubchak.testjob.DigitalZone.dto.PeriodDto;
import com.poddubchak.testjob.DigitalZone.dto.PeriodStatDto;
import com.poddubchak.testjob.DigitalZone.service.PageVisitServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(PageVisitController.class)
@AutoConfigureMockMvc
public class PageVisitControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private PageVisitServiceImpl pageVisitService;

    final ObjectMapper mapper = new ObjectMapper();


    @Test
    void visitEvent_WhenPostPageVisitDto_ThenReturnJson() throws Exception {

        final PageVisitDto pageVisitDto = new PageVisitDto(1L,5L);
        final CommonStatDto commonStatDto = new CommonStatDto(10L,3L);

        final String json = mapper.writeValueAsString(pageVisitDto);

        given(pageVisitService.visitEvent(pageVisitDto)).willReturn(commonStatDto);

        mvc.perform(post("/api/visit")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(json))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("totalVisit").value("10"))
                .andExpect(jsonPath("uniqueVisit").value("3"));
    }

    @Test
    void getStatistic_WhenPeriodDto_ThenReturnJson() throws Exception {
        final LocalDateTime start = LocalDateTime.of(2020,8,1,12,0,0);
        final LocalDateTime end = LocalDateTime.of(2020,8,2,12,0,0);
        final PeriodDto periodDto = new PeriodDto(start,end);

        final PeriodStatDto periodStatDto = new PeriodStatDto(10L,5L,2L);
        final String json = mapper.writeValueAsString(periodDto);


        given(pageVisitService.periodStat(periodDto)).willReturn(periodStatDto);

        mvc.perform(post("/api/period")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(json))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("totalVisit").value("10"))
                .andExpect(jsonPath("uniqueVisit").value("5"))
                .andExpect(jsonPath("regularVisit").value("2"));
    }
}