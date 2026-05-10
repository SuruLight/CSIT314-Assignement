package com.FRA.login_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FRA.login_system.entity.User;
import com.FRA.login_system.repository.UserRepository;

@Service
public class UpdateUserProfileService {

    @Autowired
    private UserRepository userRepository;

    public User updateProfile(String profileName, String roleType, String permissions) {
        User user = userRepository.findByUsername(profileName);

        if (user == null) {
            return null;
        }

        user.updateProfile(profileName, roleType, permissions);

        return userRepository.save(user);
    }
}