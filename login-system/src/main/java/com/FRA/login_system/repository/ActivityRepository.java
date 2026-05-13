package com.FRA.login_system.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.FRA.login_system.entity.Activity;

public interface ActivityRepository extends JpaRepository<Activity, Integer> {
    List<Activity> findByActivityNameContainingIgnoreCaseOrCategoryContainingIgnoreCaseOrStatusContainingIgnoreCase(
        String activityName,
        String category,
        String status
    );

    List<Activity> findByCreatedDate(LocalDate createdDate);
}