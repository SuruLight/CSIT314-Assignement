package com.FRA.login_system.service.FSACategoryService;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FRA.login_system.entity.Activity;
import com.FRA.login_system.entity.DailyReport;
import com.FRA.login_system.repository.ActivityRepository;

@Service
public class GenerateReportService {

    @Autowired
    private ActivityRepository activityRepository;

    public DailyReport generateReport(LocalDate reportDate) {

        List<Activity> activities = activityRepository.findByCreatedDate(reportDate);

        if (activities.isEmpty()) {
            return null;
        }

        double totalTargetAmount = 0;

        for (Activity activity : activities) {
            totalTargetAmount += activity.getTargetAmount();
        }

        DailyReport report = new DailyReport();

        return report.generateReport(reportDate, activities.size(), totalTargetAmount);
    }
}