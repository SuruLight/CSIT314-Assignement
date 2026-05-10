package com.FRA.login_system.controller.ActivityController;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.FRA.login_system.service.ActivityService.CreateActivityService;

@RestController
@RequestMapping("/api/fr/activities")
@CrossOrigin(origins = "*")
public class CreateActivityController {

    @Autowired
    private CreateActivityService createActivityService;

    @PostMapping("/create")
    public String createActivity(@RequestBody Map<String, String> request) {

        String activityName = request.get("activityName");
        String description = request.get("description");
        double targetAmount = Double.parseDouble(request.get("targetAmount"));

        return createActivityService.createActivity(activityName, description, targetAmount);
    }
}