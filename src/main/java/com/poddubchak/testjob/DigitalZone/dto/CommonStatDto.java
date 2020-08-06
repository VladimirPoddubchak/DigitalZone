package com.poddubchak.testjob.DigitalZone.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by @author Vladimir Poddubchak @date 29.07.2020.
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonStatDto {
    Long totalVisit;
    Long uniqueVisit;
}
