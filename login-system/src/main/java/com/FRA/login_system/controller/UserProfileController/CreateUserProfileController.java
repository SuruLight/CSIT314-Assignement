package com.FRA.login_system.controller.UserProfileController;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.FRA.login_system.entity.UserProfile;
import com.FRA.login_system.service.UserProfileService.CreateUserProfileService;

@RestController
@RequestMapping("/api/admin/profiles")
@CrossOrigin(origins = "*")
public class CreateUserProfileController {

    @Autowired
    private CreateUserProfileService createUserProfileService;

    @PostMapping("/create")
    public UserProfile createProfile(@RequestBody Map<String, String> request) {
        String profileName = request.get("profileName");
        String roleType = request.get("roleType");
        String permissions = request.get("permissions");
        String description = request.get("description"); // Get description from request

        return createUserProfileService.createProfile(profileName, roleType, permissions, description);
    }
}