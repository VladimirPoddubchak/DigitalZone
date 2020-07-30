package com.poddubchak.testjob.DigitalZone.repo;

import com.poddubchak.testjob.DigitalZone.model.PageVisit;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;

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
    Long getTotalVisitByPeriod(@Param("start") Date start,
                               @Param("end")Date end);

    @Query(value = "SELECT COUNT (DISTINCT user_id) " +
                   "FROM page_visit " +
                   "WHERE DATE(visit_date) BETWEEN DATE(:start) and DATE(:end)", nativeQuery = true)
    Long getUniqueVisitByPeriod(@Param("start") Date start,
                                @Param("end")Date end);


@Query(value = "WITH regular_users AS(" +
                        "SELECT DISTINCT user_id " +
                        "FROM page_visit " +
                        "WHERE DATE(visit_date) BETWEEN DATE(:start) and DATE(:end) " +
                        "GROUP BY user_id " +
                        "HAVING COUNT(user_id)>=3 )" +
                "SELECT COUNT(*) user_id " +
                "FROM regular_users", nativeQuery = true)
    Long getRegularVisitByPeriod(@Param("start") Date start,
                                 @Param("end")Date end);
}



