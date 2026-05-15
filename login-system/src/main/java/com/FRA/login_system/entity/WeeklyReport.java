package com.FRA.login_system.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "weekly_reports")
public class WeeklyReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reportId;

    private LocalDate startDate;
    private LocalDate endDate;
    private LocalDate reportDate;
    private int totalActivities;
    private double totalTargetAmount;

    public WeeklyReport() {}

    public int getReportId() { return reportId; }
    public LocalDate getStartDate() { return startDate; }
    public LocalDate getEndDate() { return endDate; }
    public LocalDate getReportDate() { return reportDate; }
    public int getTotalActivities() { return totalActivities; }
    public double getTotalTargetAmount() { return totalTargetAmount; }

    public WeeklyReport generateWeeklyReport(LocalDate startDate, LocalDate endDate, int totalActivities, double totalTargetAmount) {

        this.startDate = startDate;
        this.endDate = endDate;
        this.reportDate = startDate;
        this.totalActivities = totalActivities;
        this.totalTargetAmount = totalTargetAmount;

        return this;
    }
}