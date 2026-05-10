package com.FRA.login_system.service.ActivityService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FRA.login_system.entity.Activity;
import com.FRA.login_system.repository.ActivityRepository;

@Service
public class SearchActivityService {

    @Autowired
    private ActivityRepository activityRepository;

    public List<Activity> searchActivity(String activityName, String category,String status) {
        return activityRepository.findByActivityNameContainingIgnoreCaseOrCategoryContainingIgnoreCaseOrStatusContainingIgnoreCase(
            activityName,
            category,
            status
        );
    }
}