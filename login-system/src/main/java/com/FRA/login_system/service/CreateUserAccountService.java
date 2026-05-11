package com.FRA.login_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.FRA.login_system.entity.User;
import com.FRA.login_system.entity.UserAccount;
import com.FRA.login_system.entity.UserProfile;
import com.FRA.login_system.repository.UserRepository;
import com.FRA.login_system.repository.UserAccountRepository;
import com.FRA.login_system.repository.UserProfileRepository; // Need this to find the role

@Service
public class CreateUserAccountService {
    @Autowired private UserAccountRepository accountRepo;
    @Autowired private UserRepository passwordRepo;
    @Autowired private UserProfileRepository profileRepo; // Added this

    @Transactional
    public boolean createUserAccount(String userName, String role, String permissions, String password, String email) {
        // Check if user already exists
        if (accountRepo.findByUsername(userName) != null) {
            return false;
        }

        // 1. Find the actual Profile entity based on the role string (e.g., "FR")
        UserProfile profile = profileRepo.findById(role).orElse(null);
        if (profile == null) {
            return false; // Cannot create account if role doesn't exist
        }

        // 2. Save to useraccounts
        UserAccount account = new UserAccount();
        account.setUsername(userName);
        account.setEmail(email);
        account.setPermissions(permissions);
        account.setProfile(profile); // Set the Profile object, not the string
        account.setSuspended(false);
        accountRepo.save(account);

        // 3. Save to users (the password table)
        User pass = new User(); // Using your 'User' entity
        pass.setUsername(userName);
        pass.setPassword(password);
        passwordRepo.save(pass);

        return true;
    }
}