package com.FRA.login_system.service.ActivityService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FRA.login_system.entity.Activity;
import com.FRA.login_system.repository.ActivityRepository;

@Service
public class DeleteActivityService {

    @Autowired
    private ActivityRepository activityRepository;

    public String deleteActivity(String activityID) {

        int id = Integer.parseInt(activityID);

        Activity activity = activityRepository.findById(id).orElse(null);

        if (activity == null) {
            return "Activity not found.";
        }

        String result = activity.deleteActivity(activityID);

        activityRepository.delete(activity);

        return result;
    }
}