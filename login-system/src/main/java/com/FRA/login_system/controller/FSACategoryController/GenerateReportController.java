package com.FRA.login_system.controller.FSACategoryController;

import java.time.LocalDate;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.FRA.login_system.entity.DailyReport;
import com.FRA.login_system.service.FSACategoryService.GenerateReportService;

@RestController
@RequestMapping("/api/management/reports")
@CrossOrigin(origins = "*")
public class GenerateReportController {

    @Autowired
    private GenerateReportService generateReportService;

    @PostMapping("/daily")
    public DailyReport generateReport(@RequestBody Map<String, String> request) {

        LocalDate reportDate = LocalDate.parse(request.get("reportDate"));

        return generateReportService.generateReport(reportDate);
    }
}