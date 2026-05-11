package com.FRA.login_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FRA.login_system.entity.UserProfile;
import com.FRA.login_system.repository.UserProfileRepository;

@Service
public class SuspendUserProfileService {
    @Autowired
    private UserProfileRepository userProfileRepository;

    public UserProfile suspendProfile(String roleName) {
        UserProfile profile = userProfileRepository.findById(roleName).orElse(null);
        if (profile != null) {
            profile.setSuspended(true); // Assuming you have this setter
            return userProfileRepository.save(profile);
        }
        return null;
    }
}