package com.FRA.login_system.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.FRA.login_system.entity.FRA;

public interface FRARepository extends JpaRepository<FRA, Integer> {
    List<FRA> findByCategoryContainingIgnoreCaseAndStatusIgnoreCaseAndCompletedDate(
        String category,
        String status,
        LocalDate completedDate
    );
}