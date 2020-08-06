package com.poddubchak.testjob.DigitalZone.service;

import com.poddubchak.testjob.DigitalZone.dto.CommonStatDto;
import com.poddubchak.testjob.DigitalZone.dto.PageVisitDto;
import com.poddubchak.testjob.DigitalZone.dto.PeriodDto;
import com.poddubchak.testjob.DigitalZone.dto.PeriodStatDto;
import com.poddubchak.testjob.DigitalZone.model.PageVisit;

/**
 * Created by @author Vladimir Poddubchak @date 29.07.2020.
 */

public interface PageVisitService {
    CommonStatDto visitEvent(PageVisitDto pageVisitDto);
    PeriodStatDto periodStat(PeriodDto periodDto);
    PageVisit fromDto (PageVisitDto pageVisitDto);
}
