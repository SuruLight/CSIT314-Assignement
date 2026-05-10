package com.FRA.login_system.controller.ActivityController;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.FRA.login_system.service.ActivityService.UpdateActivityService;

@RestController
@RequestMapping("/api/fr/activities")
@CrossOrigin(origins = "*")
public class UpdateActivityController {

    @Autowired
    private UpdateActivityService updateActivityService;

    @PutMapping("/update")
    public String updateActivity(@RequestBody Map<String, String> request) {

        int activityId = Integer.parseInt(request.get("activityId"));
        String activityName = request.get("activityName");
        String description = request.get("description");
        double targetAmount = Double.parseDouble(request.get("targetAmount"));

        return updateActivityService.updateActivity(activityId, activityName, description, targetAmount);
    }
}