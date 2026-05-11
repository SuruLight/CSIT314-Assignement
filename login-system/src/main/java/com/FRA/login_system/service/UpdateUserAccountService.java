package com.FRA.login_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.FRA.login_system.entity.UserAccount;
import com.FRA.login_system.entity.UserProfile;
import com.FRA.login_system.repository.UserAccountRepository;
import com.FRA.login_system.repository.UserProfileRepository;

@Service
public class UpdateUserAccountService {

    @Autowired
    private UserAccountRepository userAccountRepository;

    @Autowired
    private UserProfileRepository userProfileRepository;

    public UserAccount updateUserAccount(String username, String roleType, String permissions) {
        // Find the account
        UserAccount account = userAccountRepository.findByUsername(username);
        if (account == null) return null;

        // Find the new Profile object (e.g., fetch the "FR" profile)
        UserProfile newProfile = userProfileRepository.findById(roleType).orElse(null);
        if (newProfile == null) return null;

        // Update the fields
        account.setProfile(newProfile);
        account.setPermissions(permissions);

        // Save and return
        return userAccountRepository.save(account);
    }
}