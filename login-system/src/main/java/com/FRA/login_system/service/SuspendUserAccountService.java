package com.FRA.login_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FRA.login_system.entity.UserAccount;
import com.FRA.login_system.repository.UserAccountRepository;

@Service
public class SuspendUserAccountService {

    @Autowired
    private UserAccountRepository userAccountRepository;

    public UserAccount updateStatus(boolean suspensionState, int userID) {
        UserAccount account = userAccountRepository.findById(userID).orElse(null);

        if (account == null) {
            return null;
        }

        account.setSuspended(suspensionState);
        return userAccountRepository.save(account);
    }

    public UserAccount fetchUserDetails(int userID) {
        return userAccountRepository.findById(userID).orElse(null);
    }
}