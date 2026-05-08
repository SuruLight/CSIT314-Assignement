package com.FRA.login_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FRA.login_system.entity.User;
import com.FRA.login_system.repository.UserRepository;

@Service
public class LoginService {
    @Autowired
    private UserRepository userRepository;

    public boolean verifyCredentials(String username, String password) {

        User user = userRepository.findByUsernameAndPassword(username, password);

        boolean loginStatus = false;

        if (user != null && !user.isSuspended()) {
            loginStatus = true;
        }

        return loginStatus;
    }

    public String getLoginMessage(String username, String password) {
        User user = userRepository.findByUsernameAndPassword(username, password);

        if (user == null) {
            return "Invalid credentials";
        }

        if (user.isSuspended()) {
            return "Account suspended";
        }

        return "Login successful";
    }
}