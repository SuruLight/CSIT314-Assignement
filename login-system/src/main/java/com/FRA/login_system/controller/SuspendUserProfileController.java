package com.FRA.login_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.FRA.login_system.entity.User;
import com.FRA.login_system.service.SuspendUserProfileService;

@RestController
@RequestMapping("/api/admin/profiles")
@CrossOrigin(origins = "*")
public class SuspendUserProfileController {

    @Autowired
    private SuspendUserProfileService suspendUserProfileService;

    @PutMapping("/{userID}/suspend")
    public User suspendProfile(@PathVariable int userID) {
        return suspendUserProfileService.suspendProfile(userID);
    }
}