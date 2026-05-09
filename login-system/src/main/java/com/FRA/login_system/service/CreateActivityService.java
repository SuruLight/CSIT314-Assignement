package com.FRA.login_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FRA.login_system.entity.Activity;
import com.FRA.login_system.repository.ActivityRepository;

@Service
public class CreateActivityService {

    @Autowired
    private ActivityRepository activityRepository;

    public String createActivity(String activityName, String description, double targetAmount) {
        if (activityName == null || activityName.isEmpty() || targetAmount <= 0) {
            return "Invalid activity details.";
        }

        Activity activity = new Activity();

        String result = activity.createActivity(activityName, description,targetAmount);

        activityRepository.save(activity);

        return result;
    }
}