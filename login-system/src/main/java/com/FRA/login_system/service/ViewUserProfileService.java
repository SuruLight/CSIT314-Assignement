package com.FRA.login_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FRA.login_system.entity.UserProfile;
import com.FRA.login_system.repository.UserProfileRepository;


@Service
public class ViewUserProfileService {

    @Autowired
    private UserProfileRepository userProfileRepository; // Use this instead of UserRepository

    public List<UserProfile> getAllUserProfiles() {
        return userProfileRepository.findAll();
    }
}