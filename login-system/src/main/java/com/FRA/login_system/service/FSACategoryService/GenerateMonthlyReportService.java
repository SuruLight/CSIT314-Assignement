package com.FRA.login_system.service.FSACategoryService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FRA.login_system.entity.Activity;
import com.FRA.login_system.entity.MonthlyReport;
import com.FRA.login_system.repository.ActivityRepository;
import com.FRA.login_system.repository.MonthlyReportRepository;

@Service
public class GenerateMonthlyReportService {

    @Autowired
    private ActivityRepository activityRepository;

    @Autowired
    private MonthlyReportRepository monthlyReportRepository; // 1. Add this injection

    public MonthlyReport generateMonthlyReport(int month, int year) {
    List<Activity> activities = activityRepository.findByMonthAndYear(month, year);

    if (activities == null || activities.isEmpty()) {
        System.out.println("No activities found for Month: " + month + " Year: " + year);
        return null;
    }

    // Calculate sum safely
    double totalAmount = activities.stream()
            .mapToDouble(Activity::getTargetAmount)
            .sum();

    MonthlyReport report = new MonthlyReport();
    report.generateMonthlyReport(month, year, activities.size(), totalAmount);

    return monthlyReportRepository.save(report);
    }
}