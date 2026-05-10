package com.FRA.login_system.service.ActivityService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FRA.login_system.entity.Activity;
import com.FRA.login_system.repository.ActivityRepository;

@Service
public class UpdateActivityService {

    @Autowired
    private ActivityRepository activityRepository;

    public String updateActivity(int activityId, String activityName, String description, double targetAmount) {
        
        Activity activity = activityRepository.findById(activityId).orElse(null);

        if (activity == null) {
            return "Activity not found.";
        }

        if (activityName == null || activityName.isEmpty() || targetAmount <= 0) {
            return "Invalid activity details.";
        }

        String result = activity.updateActivity(
            activityName,
            description,
            targetAmount
        );

        activityRepository.save(activity);

        return result;
    }
}