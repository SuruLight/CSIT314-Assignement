package com.FRA.login_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FRA.login_system.entity.UserAccount;
import com.FRA.login_system.repository.UserAccountRepository;

@Service
public class SearchUserAccountService {

    @Autowired
    private UserAccountRepository userAccountRepository;

    public List<UserAccount> searchUser(String keyword) {
        // Now using the filtered query that checks both Account and Profile status
        return userAccountRepository.searchActiveUsers(keyword);
    }
}