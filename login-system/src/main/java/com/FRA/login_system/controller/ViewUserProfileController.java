package com.FRA.login_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.FRA.login_system.entity.UserProfile;
import com.FRA.login_system.service.ViewUserProfileService;

@RestController
@RequestMapping("/api/admin/user-profiles")
@CrossOrigin(origins = "*")
public class ViewUserProfileController {

    @Autowired
    private ViewUserProfileService viewUserProfileService;

    @GetMapping("/all")
    public List<UserProfile> getAllUserProfiles() {
        return viewUserProfileService.getAllUserProfiles();
    }
}