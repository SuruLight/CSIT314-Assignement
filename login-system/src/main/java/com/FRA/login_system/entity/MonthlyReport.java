package com.FRA.login_system.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "monthly_reports")
public class MonthlyReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reportId;

    private int month;
    private int year;
    private int totalActivities;
    private double totalTargetAmount;

    public MonthlyReport() {}

    public MonthlyReport generateMonthlyReport(int month, int year, int totalActivities, double totalTargetAmount) {

        this.month = month;
        this.year = year;
        this.totalActivities = totalActivities;
        this.totalTargetAmount = totalTargetAmount;

        return this;
    }

    public int getReportId() { return reportId; }
    public int getReportMonth() { return month; }
    public int getReportYear() { return year; }
    public int getTotalActivities() { return totalActivities; }
    public double getTotalTargetAmount() { return totalTargetAmount; }
}