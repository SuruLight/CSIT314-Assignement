package com.FRA.login_system.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.FRA.login_system.entity.User;
import com.FRA.login_system.service.CreateUserProfileService;

@RestController
@RequestMapping("/api/admin/profiles")
@CrossOrigin(origins = "*")
public class CreateUserProfileController {

    @Autowired
    private CreateUserProfileService createUserProfileService;

    @PostMapping("/create")
    public User createProfile(@RequestBody Map<String, String> request) {

        String profileName = request.get("profileName");
        String roleType = request.get("roleType");
        String permissions = request.get("permissions");

        return createUserProfileService.createProfile(profileName, roleType, permissions);
    }
}