package com.FRA.login_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FRA.login_system.entity.User;
import com.FRA.login_system.repository.UserRepository;

@Service
public class CreateUserProfileService {

    @Autowired
    private UserRepository userRepository;

    public User createProfile(String profileName, String roleType, String permissions) {
        User user = new User();

        user.setUsername(profileName);
        user.setPassword("1234");
        user.setEmail(profileName + "@test.com");

        user.createProfile(profileName, roleType, permissions);

        return userRepository.save(user);
    }
}