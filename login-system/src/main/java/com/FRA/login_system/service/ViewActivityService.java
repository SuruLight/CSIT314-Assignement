package com.FRA.login_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FRA.login_system.entity.Activity;
import com.FRA.login_system.repository.ActivityRepository;

@Service
public class ViewActivityService {

    @Autowired
    private ActivityRepository activityRepository;

    public List<Activity> viewActivity() {
        return activityRepository.findAll();
    }
}