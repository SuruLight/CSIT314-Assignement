package com.FRA.login_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FRA.login_system.entity.User;
import com.FRA.login_system.repository.UserRepository;

@Service
public class CreateUserAccountService {

    @Autowired
    private UserRepository userRepository;

    public boolean createUserAccount(String userName, String role, String permissions, String password, String email) {

        User existingUser = userRepository.findByUsername(userName);

        if (existingUser != null) {
            return false;
        }

        User user = new User();
        user.setUsername(userName);
        user.setPassword(password);
        user.setRole(role);
        user.setPermissions(permissions);
        user.setEmail(email);
        user.setSuspended(false);

        userRepository.save(user);

        return true;
    }
}