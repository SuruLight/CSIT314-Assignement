package com.FRA.login_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FRA.login_system.entity.User;
import com.FRA.login_system.repository.UserRepository;

@Service
public class ViewUserProfileService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUserProfiles() {
        return userRepository.findAll();
    }
}