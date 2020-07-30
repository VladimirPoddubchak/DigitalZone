package com.poddubchak.testjob.DigitalZone.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by @author Vladimir Poddubchak @date 29.07.2020.
 */

@Entity
@Table (name = "page_visit")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PageVisit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "user_id")
    Long userId;
    @Column(name = "page_id")
    Long pageId;
    @Column(name = "visit_date")
    Date visitDate;
}
