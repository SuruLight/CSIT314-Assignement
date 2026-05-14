package com.FRA.login_system.service.FSACategoryService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FRA.login_system.entity.Activity;
import com.FRA.login_system.entity.MonthlyReport;
import com.FRA.login_system.repository.ActivityRepository;

@Service
public class GenerateMonthlyReportService {

    @Autowired
    private ActivityRepository activityRepository;

    public MonthlyReport generateMonthlyReport(int month, int year) {

        List<Activity> activities = activityRepository.findByMonthAndYear(month, year);

        if (activities.isEmpty()) {
            return null;
        }

        double totalTargetAmount = 0;

        for (Activity activity : activities) {
            totalTargetAmount += activity.getTargetAmount();
        }

        MonthlyReport monthlyReport = new MonthlyReport();

        return monthlyReport.generateMonthlyReport(month, year, activities.size(), totalTargetAmount);
    }
}