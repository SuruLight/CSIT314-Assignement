package com.FRA.login_system.controller.UserProfileController;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.FRA.login_system.entity.UserProfile;
import com.FRA.login_system.service.UserProfileService.UpdateUserProfileService;

@RestController
@RequestMapping("/api/admin/profiles")
@CrossOrigin(origins = "*")
public class UpdateUserProfileController {

    @Autowired
    private UpdateUserProfileService updateProfileService;

    @PutMapping("/update")
    public UserProfile updateProfile(@RequestBody Map<String, String> request) {
        // FIX: Change "accountName" to "profileName" to match the HTML/JS
        String profileName = request.get("profileName"); 
        String role = request.get("roleType");    
        String permissions = request.get("permissions");

        return updateProfileService.updateProfile(role, profileName, permissions);
    }
}