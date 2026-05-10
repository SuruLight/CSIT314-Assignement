package com.FRA.login_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FRA.login_system.entity.User;
import com.FRA.login_system.repository.UserRepository;

@Service
public class SuspendUserProfileService {

    @Autowired
    private UserRepository userRepository;

    public User suspendProfile(int userID) {

        User user = userRepository.findById(userID).orElse(null);

        if (user == null) {
            return null;
        }

        user.suspendProfile();

        return userRepository.save(user);
    }
}