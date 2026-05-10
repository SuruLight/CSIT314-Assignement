package com.FRA.login_system.controller.ActivityController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.FRA.login_system.entity.Activity;
import com.FRA.login_system.service.ActivityService.SearchActivityService;

@RestController
@RequestMapping("/api/fr/activities")
@CrossOrigin(origins = "*")
public class SearchActivityController {

    @Autowired
    private SearchActivityService searchActivityService;

    @GetMapping("/search")
    public List<Activity> searchActivity(
            @RequestParam String activityName,
            @RequestParam String category,
            @RequestParam String status) {

        return searchActivityService.searchActivity(activityName, category, status);
    }
}