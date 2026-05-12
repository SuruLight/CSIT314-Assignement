package com.FRA.login_system.controller.UserProfileController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.FRA.login_system.entity.UserProfile;
import com.FRA.login_system.service.UserProfileService.SuspendUserProfileService;

@RestController
@RequestMapping("/api/admin/profiles")
@CrossOrigin(origins = "*")
public class SuspendUserProfileController {

    @Autowired
    private SuspendUserProfileService suspendUserProfileService;

    @PutMapping("/{role}/suspend")
    public UserProfile suspendProfile(@PathVariable String role) {
        return suspendUserProfileService.suspendProfile(role);
    }
}