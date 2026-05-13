package com.FRA.login_system.controller.FSACategoryController;

import java.time.LocalDate;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.FRA.login_system.entity.WeeklyReport;
import com.FRA.login_system.service.FSACategoryService.GenerateWeeklyReportService;

@RestController
@RequestMapping("/api/management/reports")
@CrossOrigin(origins = "*")
public class GenerateWeeklyReportController {

    @Autowired
    private GenerateWeeklyReportService generateWeeklyReportService;

    @PostMapping("/weekly")
    public WeeklyReport generateWeeklyReport(@RequestBody Map<String, String> request) {

        LocalDate startDate = LocalDate.parse(request.get("startDate"));
        LocalDate endDate = LocalDate.parse(request.get("endDate"));

        return generateWeeklyReportService.generateWeeklyReport(startDate, endDate);
    }
}