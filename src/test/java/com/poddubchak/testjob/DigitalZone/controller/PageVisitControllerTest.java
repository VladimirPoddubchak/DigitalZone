package com.poddubchak.testjob.DigitalZone.controller;

import com.poddubchak.testjob.DigitalZone.repo.PageVisitRepo;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(PageVisitController.class)
public class PageVisitControllerTest {

    @Autowired
    PageVisitRepo pageVisitRepo;

    @Test
    void visitEvent() {
    }

    @Test
    void getStatistic() {
    }
}