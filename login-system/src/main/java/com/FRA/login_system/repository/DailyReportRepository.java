package com.FRA.login_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.FRA.login_system.entity.DailyReport;

@Repository
public interface DailyReportRepository extends JpaRepository<DailyReport, Integer> {
}