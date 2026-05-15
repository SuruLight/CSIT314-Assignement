package com.FRA.login_system.controller.FRAController;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.FRA.login_system.entity.FRA;
import com.FRA.login_system.service.FRAService.SearchCompletedFRAService;

@RestController
@RequestMapping("/api/fr/fra")
@CrossOrigin(origins = "*")
public class SearchCompletedFRAController {

    @Autowired
    private SearchCompletedFRAService searchCompletedFRAService;

    @GetMapping("/completed/search")
    public List<FRA> searchCompletedFRA(
            @RequestParam String cat,
            @RequestParam String datePeriod) {

        LocalDate date = LocalDate.parse(datePeriod);

        return searchCompletedFRAService.searchCompletedFRA(cat, date);
    }
}