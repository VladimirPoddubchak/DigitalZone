package com.poddubchak.testjob.DigitalZone.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by @author Vladimir Poddubchak @date 29.07.2020.
 */

@Data
@Slf4j
@AllArgsConstructor
@NoArgsConstructor
public class PeriodStatDto {

    Long totalVisit;
    Long uniqueVisit;
    Long regularVisit;
}
