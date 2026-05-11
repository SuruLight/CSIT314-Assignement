package com.FRA.login_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FRA.login_system.entity.UserAccount;
import com.FRA.login_system.repository.UserAccountRepository;

@Service
public class ViewUserAccountService {

    @Autowired
    private UserAccountRepository userRepository;

    public UserAccount getUser(int userID) {

        return userRepository.findById(userID).orElse(null);
    }
}