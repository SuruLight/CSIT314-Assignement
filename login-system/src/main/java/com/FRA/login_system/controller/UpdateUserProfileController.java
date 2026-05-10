package com.FRA.login_system.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.FRA.login_system.entity.User;
import com.FRA.login_system.service.UpdateUserProfileService;

@RestController
@RequestMapping("/api/admin/profiles")
@CrossOrigin(origins = "*")
public class UpdateUserProfileController {

    @Autowired
    private UpdateUserProfileService updateProfileService;

    @PutMapping("/update")
    public User updateProfile(@RequestBody Map<String, String> request) {

        String profileName = request.get("profileName");
        String roleType = request.get("roleType");
        String permissions = request.get("permissions");

        return updateProfileService.updateProfile(
            profileName,
            roleType,
            permissions
        );
    }
}