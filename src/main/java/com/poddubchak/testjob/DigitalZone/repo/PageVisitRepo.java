package com.poddubchak.testjob.DigitalZone.repo;

import com.poddubchak.testjob.DigitalZone.model.PageVisit;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

/**
 * Created by @author Vladimir Poddubchak @date 29.07.2020.
 */

@Repository
public interface PageVisitRepo extends CrudRepository<PageVisit,Long> {

    @Query(value = "SELECT COUNT(user_id) " +
                    "FROM page_visit " +
                    "WHERE DATE(visit_date)=CURRENT_DATE",nativeQuery = true)
    Long getTotalVisitByDay();

    @Query(value = "SELECT COUNT (DISTINCT user_id) " +
                    "FROM page_visit " +
                    "WHERE DATE(visit_date)=CURRENT_DATE", nativeQuery = true)
    Long getUniqueVisitByDay();

    @Query(value = "SELECT COUNT(user_id) " +
                    "FROM page_visit " +
                    "WHERE DATE(visit_date) BETWEEN DATE(:start) and DATE(:end)",nativeQuery = true)
    Long getTotalVisitByPeriod(@Param("start") LocalDateTime start,
                               @Param("end")LocalDateTime end);

    @Query(value = "SELECT COUNT (DISTINCT user_id) " +
                   "FROM page_visit " +
                   "WHERE DATE(visit_date) BETWEEN DATE(:start) and DATE(:end)", nativeQuery = true)
    Long getUniqueVisitByPeriod(@Param("start") LocalDateTime start,
                                @Param("end")LocalDateTime end);

    @Query(value = "WITH unique_visits AS(" +
                        "SELECT DISTINCT user_id, page_id " +
                        "FROM page_visit " +
                        "WHERE DATE(visit_date) BETWEEN DATE(:start) and DATE(:end)), " +
                    "regular_users AS(" +
                        "SELECT user_id, count(page_id) " +
                        "FROM unique_visits " +
                        "GROUP BY user_id " +
                        "HAVING COUNT(page_id)>=10 )" +
                "SELECT COUNT(*) " +
                "FROM regular_users", nativeQuery = true)
    Long getRegularVisitByPeriod(@Param("start") LocalDateTime start,
                                 @Param("end")LocalDateTime end);
}



