package com.poddubchak.testjob.DigitalZone.repo;

import com.poddubchak.testjob.DigitalZone.model.PageVisit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class PageVisitRepoTest {

    @Autowired
    PageVisitRepo repo;

    @BeforeEach
    public void setup() {
        this.repo.deleteAll();
    }

    final PageVisit user1page1Today = PageVisit.builder().userId(1L).pageId(1L).visitDate(LocalDateTime.now()).build();
    final PageVisit user2page1Today = PageVisit.builder().userId(2L).pageId(1L).visitDate(LocalDateTime.now()).build();
    final PageVisit user2page2Today = PageVisit.builder().userId(2L).pageId(2L).visitDate(LocalDateTime.now()).build();
    final PageVisit user3page1Today = PageVisit.builder().userId(3L).pageId(1L).visitDate(LocalDateTime.now()).build();
    final PageVisit user3page2Today = PageVisit.builder().userId(3L).pageId(2L).visitDate(LocalDateTime.now()).build();
    final PageVisit user3page3Today = PageVisit.builder().userId(3L).pageId(3L).visitDate(LocalDateTime.now()).build();

    final PageVisit user1page1Yesterday = PageVisit.builder().userId(1L).pageId(1L).visitDate(LocalDateTime.now().minusDays(1L)).build();
    final PageVisit user1page2Yesterday = PageVisit.builder().userId(1L).pageId(2L).visitDate(LocalDateTime.now().minusDays(1L)).build();
    final PageVisit user1page3Yesterday = PageVisit.builder().userId(1L).pageId(3L).visitDate(LocalDateTime.now().minusDays(1L)).build();
    final PageVisit user1page4Yesterday = PageVisit.builder().userId(1L).pageId(4L).visitDate(LocalDateTime.now().minusDays(1L)).build();
    final PageVisit user1page5Yesterday = PageVisit.builder().userId(1L).pageId(5L).visitDate(LocalDateTime.now().minusDays(1L)).build();
    final PageVisit user1page6Yesterday = PageVisit.builder().userId(1L).pageId(6L).visitDate(LocalDateTime.now().minusDays(1L)).build();
    final PageVisit user1page7Yesterday = PageVisit.builder().userId(1L).pageId(7L).visitDate(LocalDateTime.now().minusDays(1L)).build();
    final PageVisit user1page8Yesterday = PageVisit.builder().userId(1L).pageId(8L).visitDate(LocalDateTime.now().minusDays(1L)).build();
    final PageVisit user1page9Yesterday = PageVisit.builder().userId(1L).pageId(9L).visitDate(LocalDateTime.now().minusDays(1L)).build();

    final PageVisit user2page1Yesterday = PageVisit.builder().userId(2L).pageId(1L).visitDate(LocalDateTime.now().minusDays(1L)).build();
    final PageVisit user2page2Yesterday = PageVisit.builder().userId(2L).pageId(2L).visitDate(LocalDateTime.now().minusDays(1L)).build();
    final PageVisit user3page1Yesterday = PageVisit.builder().userId(3L).pageId(1L).visitDate(LocalDateTime.now().minusDays(1L)).build();
    final PageVisit user3page2Yesterday = PageVisit.builder().userId(3L).pageId(2L).visitDate(LocalDateTime.now().minusDays(1L)).build();
    final PageVisit user3page3Yesterday = PageVisit.builder().userId(3L).pageId(3L).visitDate(LocalDateTime.now().minusDays(1L)).build();

    final PageVisit user1page1TwoDaysAgo = PageVisit.builder().userId(1L).pageId(1L).visitDate(LocalDateTime.now().minusDays(2L)).build();
    final PageVisit user1page2TwoDaysAgo = PageVisit.builder().userId(1L).pageId(2L).visitDate(LocalDateTime.now().minusDays(2L)).build();
    final PageVisit user1page3TwoDaysAgo = PageVisit.builder().userId(1L).pageId(3L).visitDate(LocalDateTime.now().minusDays(2L)).build();
    final PageVisit user1page4TwoDaysAgo = PageVisit.builder().userId(1L).pageId(4L).visitDate(LocalDateTime.now().minusDays(2L)).build();
    final PageVisit user1page5TwoDaysAgo = PageVisit.builder().userId(1L).pageId(5L).visitDate(LocalDateTime.now().minusDays(2L)).build();
    final PageVisit user1page6TwoDaysAgo = PageVisit.builder().userId(1L).pageId(6L).visitDate(LocalDateTime.now().minusDays(2L)).build();
    final PageVisit user1page7TwoDaysAgo = PageVisit.builder().userId(1L).pageId(7L).visitDate(LocalDateTime.now().minusDays(2L)).build();
    final PageVisit user1page8TwoDaysAgo = PageVisit.builder().userId(1L).pageId(8L).visitDate(LocalDateTime.now().minusDays(2L)).build();
    final PageVisit user1page9TwoDaysAgo = PageVisit.builder().userId(1L).pageId(9L).visitDate(LocalDateTime.now().minusDays(2L)).build();
    final PageVisit user1page10TwoDaysAgo = PageVisit.builder().userId(1L).pageId(10L).visitDate(LocalDateTime.now().minusDays(2L)).build();

    final PageVisit user1page1WeekAgo = PageVisit.builder().userId(1L).pageId(1L).visitDate(LocalDateTime.now().minusWeeks(1L)).build();
    final PageVisit user2page1WeekAgo = PageVisit.builder().userId(2L).pageId(1L).visitDate(LocalDateTime.now().minusWeeks(1L)).build();
    final PageVisit user2page2WeekAgo = PageVisit.builder().userId(2L).pageId(2L).visitDate(LocalDateTime.now().minusWeeks(1L)).build();

    final PageVisit user3page1WeekAgo = PageVisit.builder().userId(3L).pageId(1L).visitDate(LocalDateTime.now().minusWeeks(1L)).build();
    final PageVisit user3page2WeekAgo = PageVisit.builder().userId(3L).pageId(2L).visitDate(LocalDateTime.now().minusWeeks(1L)).build();
    final PageVisit user3page3WeekAgo = PageVisit.builder().userId(3L).pageId(3L).visitDate(LocalDateTime.now().minusWeeks(1L)).build();
    final PageVisit user3page4WeekAgo = PageVisit.builder().userId(3L).pageId(4L).visitDate(LocalDateTime.now().minusWeeks(1L)).build();
    final PageVisit user3page5WeekAgo = PageVisit.builder().userId(3L).pageId(5L).visitDate(LocalDateTime.now().minusWeeks(1L)).build();
    final PageVisit user3page6WeekAgo = PageVisit.builder().userId(3L).pageId(6L).visitDate(LocalDateTime.now().minusWeeks(1L)).build();
    final PageVisit user3page7WeekAgo = PageVisit.builder().userId(3L).pageId(7L).visitDate(LocalDateTime.now().minusWeeks(1L)).build();
    final PageVisit user3page8WeekAgo = PageVisit.builder().userId(3L).pageId(8L).visitDate(LocalDateTime.now().minusWeeks(1L)).build();
    final PageVisit user3page9WeekAgo = PageVisit.builder().userId(3L).pageId(9L).visitDate(LocalDateTime.now().minusWeeks(1L)).build();
    final PageVisit user3page10WeekAgo = PageVisit.builder().userId(3L).pageId(10L).visitDate(LocalDateTime.now().minusWeeks(1L)).build();
    final PageVisit user3page11WeekAgo = PageVisit.builder().userId(3L).pageId(11L).visitDate(LocalDateTime.now().minusWeeks(1L)).build();

    final PageVisit user3page1MonthAgo = PageVisit.builder().userId(3L).pageId(1L).visitDate(LocalDateTime.now().minusMonths(1L)).build();
    final PageVisit user3page2MonthAgo = PageVisit.builder().userId(3L).pageId(2L).visitDate(LocalDateTime.now().minusMonths(1L)).build();
    final PageVisit user3page3MonthAgo = PageVisit.builder().userId(3L).pageId(3L).visitDate(LocalDateTime.now().minusMonths(1L)).build();

    @Test
    void getTotalVisitByDay_WhenRepoIsEmpty_ThenReturn_0() {
        assertEquals(0, repo.count());
        assertEquals(0, repo.getTotalVisitByDay());
    }

    @Test
    void getTotalVisitByDay_WhenNoVisitToday_ThenReturn_0() {
        repo.save(user1page1Yesterday);
        repo.save(user2page1WeekAgo);
        repo.save(user3page1MonthAgo);
        assertEquals(0, repo.getTotalVisitByDay());
        assertEquals(3, repo.count());
    }

    @Test
    void getTotalVisitByDay_WhenIsVisitsToday_ThenOK() {
        repo.save(user1page1Today);
        repo.save(user2page1Today);
        repo.save(user2page2Today);
        repo.save(user3page1Today);
        repo.save(user3page2Today);
        repo.save(user3page3Today);

        repo.save(user1page1Yesterday);
        repo.save(user2page2WeekAgo);
        repo.save(user3page3MonthAgo);

        assertEquals(6, repo.getTotalVisitByDay());
        assertEquals(9, repo.count());
    }

    @Test
    void getUniqueVisitByDay_WhenRepoIsEmpty_ThenReturn_0() {
        assertEquals(0, repo.count());
        assertEquals(0, repo.getUniqueVisitByDay());
    }

    @Test
    void getUniqueVisitByDay_WhenNoVisitToday_ThenReturn_0() {
        repo.save(user1page1Yesterday);
        repo.save(user2page1WeekAgo);
        repo.save(user3page1MonthAgo);
        assertEquals(0, repo.getUniqueVisitByDay());
        assertEquals(3, repo.count());
    }
    @Test
    void getUniqueVisitByDay_WhenIsVisitsToday_ThenOK() {
        repo.save(user1page1Today);
        repo.save(user2page1Today);
        repo.save(user2page2Today);
        repo.save(user3page1Today);
        repo.save(user3page2Today);
        repo.save(user3page3Today);

        repo.save(user1page1Yesterday);
        repo.save(user1page1WeekAgo);
        repo.save(user2page2WeekAgo);
        repo.save(user3page1MonthAgo);
        repo.save(user3page2MonthAgo);
        repo.save(user3page3MonthAgo);

        assertEquals(3, repo.getUniqueVisitByDay());
        assertEquals(12, repo.count());
    }


    @Test
    void getTotalVisitByPeriod_WhenRepoIsEmpty_ThenReturn_0() {
        assertEquals(0, repo.count());
        assertEquals(0, repo.getTotalVisitByPeriod(LocalDateTime.now(),LocalDateTime.now()));
    }

    @Test
    void getTotalVisitByPeriod_WhenNoVisitInPeriod_ThenReturn_0() {
        repo.save(user1page1WeekAgo);
        repo.save(user2page1WeekAgo);
        repo.save(user3page1MonthAgo);
        repo.save(user3page3MonthAgo);
        assertEquals(4, repo.count());
        assertEquals(0, repo.getTotalVisitByPeriod(LocalDateTime.now().minusDays(6L),LocalDateTime.now()));
    }

    @Test
    void getTotalVisitByPeriod_WhenIsVisitInPeriod_ThenOK() {
        repo.save(user1page1Today);
        repo.save(user2page1Today);
        repo.save(user2page2Today);
        repo.save(user3page1Today);
        repo.save(user3page2Today);
        repo.save(user3page3Today);

        repo.save(user1page1Yesterday);
        repo.save(user2page1Yesterday);
        repo.save(user3page1Yesterday);

        repo.save(user1page1WeekAgo);
        repo.save(user2page1WeekAgo);
        repo.save(user3page1WeekAgo);

        repo.save(user3page1MonthAgo);
        repo.save(user3page2MonthAgo);
        repo.save(user3page3MonthAgo);
        assertEquals(15, repo.count());
        assertEquals(6, repo.getTotalVisitByPeriod(LocalDateTime.now().minusWeeks(2L),LocalDateTime.now().minusDays(1L)));
    }

    @Test
    void getUniqueVisitByPeriod_WhenRepoIsEmpty_ThenReturn_0() {
        assertEquals(0, repo.getUniqueVisitByPeriod(LocalDateTime.now(),LocalDateTime.now()));
    }

    @Test
    void getUniqueVisitByPeriod_WhenNoVisitsInPeriod_ThenReturn_0() {
        repo.save(user1page1WeekAgo);
        repo.save(user2page1WeekAgo);
        repo.save(user3page1MonthAgo);
        repo.save(user3page3MonthAgo);
        assertEquals(4, repo.count());
        assertEquals(0, repo.getUniqueVisitByPeriod(LocalDateTime.now().minusDays(6L),LocalDateTime.now()));
    }

    @Test
    void getUniqueVisitByPeriod_WhenIsVisitsInPeriod_ThenOK() {
        repo.save(user1page1Today);
        repo.save(user2page1Today);
        repo.save(user2page2Today);

        repo.save(user1page1Yesterday);
        repo.save(user2page1Yesterday);
        repo.save(user2page2Yesterday);
        repo.save(user3page1Yesterday);
        repo.save(user3page2Yesterday);
        repo.save(user3page3Yesterday);

        repo.save(user1page1WeekAgo);
        repo.save(user2page1WeekAgo);
        repo.save(user3page1WeekAgo);

        repo.save(user3page1MonthAgo);
        repo.save(user3page2MonthAgo);
        repo.save(user3page3MonthAgo);
        assertEquals(15, repo.count());
        assertEquals(3, repo.getUniqueVisitByPeriod(LocalDateTime.now().minusWeeks(2L),LocalDateTime.now().minusDays(1L)));
    }

    @Test
    void getRegularVisitByPeriod_WhenRepoIsEmpty_ThenReturn_0() {
        assertEquals(0, repo.getRegularVisitByPeriod(LocalDateTime.now(),LocalDateTime.now()));
    }

    @Test
    void getRegularVisitByPeriod_WhenNoVisitsInPeriod_ThenReturn_0() {
        repo.save(user1page1WeekAgo);
        repo.save(user2page1WeekAgo);
        repo.save(user3page1MonthAgo);
        repo.save(user3page3MonthAgo);
        assertEquals(4, repo.count());
        assertEquals(0, repo.getRegularVisitByPeriod(LocalDateTime.now().minusDays(6L),LocalDateTime.now()));
    }

    @Test
    void getRegularVisitByPeriod_WhenNotEnoughVisitsInPeriod_ThenReturn_0() {
        repo.save(user1page1Today);
        repo.save(user2page1Today);
        repo.save(user2page2Today);

        repo.save(user1page1Yesterday);
        repo.save(user2page1Yesterday);
        repo.save(user2page2Yesterday);
        repo.save(user3page1Yesterday);
        repo.save(user3page2Yesterday);
        repo.save(user3page3Yesterday);

        repo.save(user1page1TwoDaysAgo);
        repo.save(user1page2TwoDaysAgo);
        repo.save(user1page3TwoDaysAgo);
        repo.save(user1page4TwoDaysAgo);
        repo.save(user1page5TwoDaysAgo);
        repo.save(user1page6TwoDaysAgo);
        repo.save(user1page7TwoDaysAgo);
        repo.save(user1page8TwoDaysAgo);
        repo.save(user1page9TwoDaysAgo);
        repo.save(user1page10TwoDaysAgo);

        repo.save(user1page1WeekAgo);
        repo.save(user2page1WeekAgo);
        repo.save(user3page1WeekAgo);

        repo.save(user3page1MonthAgo);
        repo.save(user3page2MonthAgo);
        repo.save(user3page3MonthAgo);
        assertEquals(25, repo.count());
        assertEquals(0, repo.getRegularVisitByPeriod(LocalDateTime.now().minusWeeks(2L),LocalDateTime.now().minusDays(3L)));
    }

    @Test
    void getRegularVisitByPeriod_WhenEnoughVisitsInPeriod_Then_Ok() {
        repo.save(user1page1Today);
        repo.save(user2page1Today);
        repo.save(user2page2Today);

        repo.save(user1page1Yesterday);
        repo.save(user1page2Yesterday);
        repo.save(user1page3Yesterday);
        repo.save(user1page4Yesterday);
        repo.save(user1page5Yesterday);
        repo.save(user1page6Yesterday);
        repo.save(user1page7Yesterday);
        repo.save(user1page8Yesterday);
        repo.save(user1page9Yesterday);

        repo.save(user2page1Yesterday);
        repo.save(user2page2Yesterday);
        repo.save(user3page1Yesterday);
        repo.save(user3page2Yesterday);
        repo.save(user3page3Yesterday);

        repo.save(user1page1TwoDaysAgo);
        repo.save(user1page2TwoDaysAgo);
        repo.save(user1page3TwoDaysAgo);
        repo.save(user1page4TwoDaysAgo);
        repo.save(user1page5TwoDaysAgo);
        repo.save(user1page6TwoDaysAgo);
        repo.save(user1page7TwoDaysAgo);
        repo.save(user1page8TwoDaysAgo);
        repo.save(user1page9TwoDaysAgo);
        repo.save(user1page10TwoDaysAgo);

        repo.save(user1page1WeekAgo);
        repo.save(user2page1WeekAgo);

        repo.save(user3page1WeekAgo);
        repo.save(user3page2WeekAgo);
        repo.save(user3page3WeekAgo);
        repo.save(user3page4WeekAgo);
        repo.save(user3page5WeekAgo);
        repo.save(user3page6WeekAgo);
        repo.save(user3page7WeekAgo);
        repo.save(user3page8WeekAgo);
        repo.save(user3page9WeekAgo);
        repo.save(user3page10WeekAgo);
        repo.save(user3page11WeekAgo);

        repo.save(user3page1MonthAgo);
        repo.save(user3page2MonthAgo);
        repo.save(user3page3MonthAgo);
        assertEquals(43, repo.count());
        assertEquals(2, repo.getRegularVisitByPeriod(LocalDateTime.now().minusWeeks(2L),LocalDateTime.now().minusDays(1L)));
    }
}