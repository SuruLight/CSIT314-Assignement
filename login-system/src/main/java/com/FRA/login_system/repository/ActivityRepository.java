package com.FRA.login_system.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.FRA.login_system.entity.Activity;

public interface ActivityRepository extends JpaRepository<Activity, Integer> {
    List<Activity> findByActivityNameContainingIgnoreCaseOrCategoryContainingIgnoreCaseOrStatusContainingIgnoreCase(
        String activityName,
        String category,
        String status
    );

    // For generating daily report
    List<Activity> findByCreatedDate(LocalDate createdDate);
    // For generating weekly report
    List<Activity> findByCreatedDateBetween(LocalDate startDate, LocalDate endDate);

    // For generating monthly report
    @Query("SELECT a FROM Activity a WHERE MONTH(a.createdDate) = :month AND YEAR(a.createdDate) = :year")
    List<Activity> findByMonthAndYear(@Param("month") int month, @Param("year") int year);
}