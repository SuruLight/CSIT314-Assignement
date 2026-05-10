package com.FRA.login_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.FRA.login_system.entity.Activity;
import com.FRA.login_system.service.ViewActivityService;

@RestController
@RequestMapping("/api/fr/activities")
@CrossOrigin(origins = "*")
public class ViewActivityController {

    @Autowired
    private ViewActivityService viewActivityService;

    @GetMapping("/view")
    public List<Activity> viewActivity() {
        return viewActivityService.viewActivity();
    }
}