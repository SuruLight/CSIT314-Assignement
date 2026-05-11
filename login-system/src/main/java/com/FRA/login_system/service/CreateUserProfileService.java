package com.FRA.login_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.FRA.login_system.entity.UserProfile;
import com.FRA.login_system.repository.UserProfileRepository;

@Service
public class CreateUserProfileService {

    @Autowired
    private UserProfileRepository userProfileRepository; // Changed to UserProfileRepository

    public UserProfile createProfile(String profileName, String roleType, String permissions, String description) {
        // Create a new UserProfile object (the role)
        UserProfile profile = new UserProfile();

        profile.setRole(roleType);         // e.g., "MANAGER"
        profile.setProfileName(profileName); // e.g., "System Manager"
        profile.setPermissions(permissions);
        profile.setDescription(description);
        profile.setSuspended(false);

        // Save to the 'userprofiles' table
        return userProfileRepository.save(profile);
    }
}