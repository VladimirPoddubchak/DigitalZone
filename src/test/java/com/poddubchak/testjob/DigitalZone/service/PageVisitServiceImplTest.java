package com.poddubchak.testjob.DigitalZone.service;

import com.poddubchak.testjob.DigitalZone.dto.CommonStatDto;
import com.poddubchak.testjob.DigitalZone.dto.PageVisitDto;
import com.poddubchak.testjob.DigitalZone.dto.PeriodDto;
import com.poddubchak.testjob.DigitalZone.dto.PeriodStatDto;
import com.poddubchak.testjob.DigitalZone.model.PageVisit;
import com.poddubchak.testjob.DigitalZone.repo.PageVisitRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.Duration;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(SpringExtension.class)

class PageVisitServiceImplTest {
    @TestConfiguration
    static class PageVisitServiceImplTestContextConfiguration{

        @Bean
        public PageVisitService pageVisitService(){
            return new PageVisitServiceImpl();
        }

    }

    @Autowired
    private PageVisitService pageVisitService;

    @MockBean
    private PageVisitRepo pageVisitRepo;

    @BeforeEach
    public void setUp(){
        Mockito.when(pageVisitRepo.getTotalVisitByDay()).thenReturn(10L);
        Mockito.when(pageVisitRepo.getUniqueVisitByDay()).thenReturn(5L);

        final LocalDateTime start = LocalDateTime.of(2020,8,1,12,0,0);
        final LocalDateTime end = LocalDateTime.of(2020,8,2,12,0,0);

        Mockito.when(pageVisitRepo.getTotalVisitByPeriod(start,end)).thenReturn(20L);
        Mockito.when(pageVisitRepo.getUniqueVisitByPeriod(start,end)).thenReturn(10L);
        Mockito.when(pageVisitRepo.getRegularVisitByPeriod(start,end)).thenReturn(1L);

    }

    @Test
    void visitEvent_WhenPageVisitDtoIsNull_ThenReturn_Null() {
        final PageVisitDto pageVisitDto = null;

        assertNull(pageVisitService.visitEvent(pageVisitDto) );
    }

    @Test
    void visitEvent_WhenUserIdIsNull_ThenReturn_Null() {
        final PageVisitDto pageVisitDto = new PageVisitDto(null,5L);

        assertNull(pageVisitService.visitEvent(pageVisitDto) );
    }

    @Test
    void visitEvent_WhenPageIdIsNull_ThenReturn_Null() {
        final PageVisitDto pageVisitDto = new PageVisitDto(5L,null);

        assertNull(pageVisitService.visitEvent(pageVisitDto) );
    }


    @Test
    void visitEvent_WhenPageVisitDtoIsValid_ThenReturn_Ok() {
        final PageVisitDto pageVisitDto = new PageVisitDto(5L,5L);
        final CommonStatDto commonStatDto = new CommonStatDto(10L,5L);
        assertEquals(commonStatDto, pageVisitService.visitEvent(pageVisitDto));
    }


    @Test
    void periodStat() {
    }

    @Test
    void periodStat_WhenPeriodDtoIsNull_ThenReturn_Null() {
        final PeriodDto periodDto = null;

        assertNull(pageVisitService.periodStat(periodDto) );
    }

    @Test
    void periodStat_WhenStartIsNull_ThenReturn_Null() {
        final LocalDateTime start = null;
        final LocalDateTime end = LocalDateTime.now();
        final PeriodDto periodDto = new PeriodDto(start,end);

        assertNull(pageVisitService.periodStat(periodDto) );
    }

    @Test
    void periodStat_WhenEndIsNull_ThenReturn_Null() {
        final LocalDateTime start = LocalDateTime.now();
        final LocalDateTime end = null;
        final PeriodDto periodDto = new PeriodDto(start,end);

        assertNull(pageVisitService.periodStat(periodDto) );
    }

    @Test
    void periodStat_WhenStartIsAfterEnd_ThenReturn_Null() {
        final LocalDateTime start = LocalDateTime.now();
        final LocalDateTime end = LocalDateTime.now().minusWeeks(1);
        final PeriodDto periodDto = new PeriodDto(start,end);

        assertNull(pageVisitService.periodStat(periodDto) );
    }

    @Test
    void periodStat_WhenPeriodDtoIsValid_ThenReturn_Ok() {
        final LocalDateTime start = LocalDateTime.of(2020,8,1,12,0,0);
        final LocalDateTime end = LocalDateTime.of(2020,8,2,12,0,0);
        final PeriodDto periodDto = new PeriodDto(start,end);

        final PeriodStatDto periodStatDto = new PeriodStatDto(20L, 10L, 1L);

        assertEquals(periodStatDto, pageVisitService.periodStat(periodDto));
    }



    @Test
    void fromDto() {
        final PageVisitDto  pageVisitDto = new PageVisitDto(1L,1L);
        final PageVisit pageVisit= PageVisit.builder()
                .userId(1L)
                .pageId(1L)
                .visitDate(LocalDateTime.now())
                .build();

        assertNull(pageVisitService.fromDto(pageVisitDto).getId());
        assertEquals(pageVisit.getUserId(), pageVisitService.fromDto(pageVisitDto).getUserId());
        assertEquals(pageVisit.getPageId(), pageVisitService.fromDto(pageVisitDto).getPageId());

        Duration duration = Duration.between(pageVisit.getVisitDate(), pageVisitService.fromDto(pageVisitDto).getVisitDate());
        assertEquals(0, duration.toSeconds());
    }
}