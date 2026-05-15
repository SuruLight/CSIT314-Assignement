package com.FRA.login_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.FRA.login_system.entity.MonthlyReport;

@Repository
public interface MonthlyReportRepository extends JpaRepository<MonthlyReport, Integer> {
}