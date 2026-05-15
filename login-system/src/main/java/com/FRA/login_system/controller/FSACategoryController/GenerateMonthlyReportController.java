package com.FRA.login_system.controller.FSACategoryController;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.FRA.login_system.entity.MonthlyReport;
import com.FRA.login_system.service.FSACategoryService.GenerateMonthlyReportService;

@RestController
@RequestMapping("/api/management/reports")
@CrossOrigin(origins = "*")
public class GenerateMonthlyReportController {

    @Autowired
    private GenerateMonthlyReportService generateMonthlyReportService;

    @PostMapping("/monthly")
    public MonthlyReport generateMonthlyReport(@RequestBody Map<String, String> request) {
        // These lines take whatever the user types in the HTML
        int month = Integer.parseInt(request.get("month"));
        int year = Integer.parseInt(request.get("year"));

        return generateMonthlyReportService.generateMonthlyReport(month, year);
    }
}