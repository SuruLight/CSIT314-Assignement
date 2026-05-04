package com.FRA.login_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FRA.login_system.entity.User;
import com.FRA.login_system.repository.UserRepository;

@Service
public class ViewUserAccountService {

    @Autowired
    private UserRepository userRepository;

    public User getUser(int userID) {
        return userRepository.findById(userID).orElse(null);
    }
}