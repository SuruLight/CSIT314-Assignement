package com.FRA.login_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FRA.login_system.entity.UserProfile;
import com.FRA.login_system.repository.UserProfileRepository;

@Service
public class SearchUserProfileService {

    @Autowired
    private UserProfileRepository userProfileRepository;

    public List<UserProfile> searchUser(String criteria) {
        // Search in the userprofiles table
        return userProfileRepository.findByRoleContainingIgnoreCaseOrDescriptionContainingIgnoreCase(
            criteria, 
            criteria
        );
    }
}