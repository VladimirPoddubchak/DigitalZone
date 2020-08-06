package com.poddubchak.testjob.DigitalZone.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Created by @author Vladimir Poddubchak @date 29.07.2020.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PeriodDto {
    @JsonSerialize(using = ToStringSerializer.class)
    LocalDateTime start;
    @JsonSerialize(using = ToStringSerializer.class)
    LocalDateTime end;
}
