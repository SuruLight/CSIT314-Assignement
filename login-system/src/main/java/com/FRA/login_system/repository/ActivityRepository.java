package com.FRA.login_system.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.FRA.login_system.entity.Activity;

public interface ActivityRepository extends JpaRepository<Activity, Integer> {
    @Query("""
        SELECT a FROM Activity a
        WHERE (:activityName = '' OR LOWER(a.activityName) LIKE LOWER(CONCAT('%', :activityName, '%')))
        AND (:category = '' OR LOWER(a.category) LIKE LOWER(CONCAT('%', :category, '%')))
        AND (:status = '' OR LOWER(a.status) LIKE LOWER(CONCAT('%', :status, '%')))
    """)
    List<Activity> searchActivity(
        @Param("activityName") String activityName,
        @Param("category") String category,
        @Param("status") String status
    );

    // For generating daily report
    List<Activity> findByCreatedDate(LocalDate createdDate);
    // For generating weekly report
    List<Activity> findByCreatedDateBetween(LocalDate startDate, LocalDate endDate);

    // For generating monthly report
    @Query("SELECT a FROM Activity a WHERE MONTH(a.createdDate) = :month AND YEAR(a.createdDate) = :year")
    List<Activity> findByMonthAndYear(@Param("month") int month, @Param("year") int year);
}