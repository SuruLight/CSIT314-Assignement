package com.FRA.login_system.service.FSACategoryService;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FRA.login_system.entity.Activity;
import com.FRA.login_system.entity.WeeklyReport;
import com.FRA.login_system.repository.ActivityRepository;

@Service
public class GenerateWeeklyReportService {

    @Autowired
    private ActivityRepository activityRepository;

    public WeeklyReport generateWeeklyReport(LocalDate startDate, LocalDate endDate) {

        List<Activity> activities =
            activityRepository.findByCreatedDateBetween(startDate, endDate);

        if (activities.isEmpty()) {
            return null;
        }

        double totalTargetAmount = 0;

        for (Activity activity : activities) {
            totalTargetAmount += activity.getTargetAmount();
        }

        WeeklyReport weeklyReport = new WeeklyReport();

        return weeklyReport.generateWeeklyReport(startDate, endDate, activities.size(), totalTargetAmount);
    }
}