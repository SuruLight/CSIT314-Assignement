package com.FRA.login_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.FRA.login_system.entity.UserProfile;
import com.FRA.login_system.repository.UserProfileRepository;

@Service
public class UpdateUserProfileService {

    @Autowired
    private UserProfileRepository userProfileRepository;

    public UserProfile updateProfile(String role, String profileName, String permissions) {
    UserProfile profile = userProfileRepository.findById(role).orElse(null);

    if (profile == null) {
        return null;
    }

        // This part is correct, it sets the new values on the existing object
        profile.setProfileName(profileName);
        profile.setPermissions(permissions);

        return userProfileRepository.save(profile);
    }
}