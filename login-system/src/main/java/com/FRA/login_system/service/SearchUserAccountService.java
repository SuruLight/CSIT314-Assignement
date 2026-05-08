package com.FRA.login_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FRA.login_system.entity.User;
import com.FRA.login_system.repository.UserRepository;

@Service
public class SearchUserAccountService {

    @Autowired
    private UserRepository userRepository;

    public List<User> searchUser(String keyword) {
        return userRepository.findByUsernameContainingIgnoreCaseOrFullNameContainingIgnoreCaseOrEmailContainingIgnoreCase(
            keyword,
            keyword,
            keyword
        );
    }
}