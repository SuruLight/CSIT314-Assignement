package com.FRA.login_system.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "daily_reports")
public class DailyReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reportId;

    private LocalDate reportDate;
    private int totalActivities;
    private double totalTargetAmount;

    public DailyReport() {}

    public int getReportId() {return reportId;}
    public LocalDate getReportDate() {return reportDate;}
    public int getTotalActivities() {return totalActivities;}
    public double getTotalTargetAmount() {return totalTargetAmount;}

    public DailyReport generateReport(LocalDate reportDate, int totalActivities, double totalTargetAmount) {

        this.reportDate = reportDate;
        this.totalActivities = totalActivities;
        this.totalTargetAmount = totalTargetAmount;

        return this;
    }
}