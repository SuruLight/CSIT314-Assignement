package com.FRA.login_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.FRA.login_system.entity.User;
import com.FRA.login_system.entity.UserAccount;
import com.FRA.login_system.repository.UserRepository;
import com.FRA.login_system.repository.UserAccountRepository;

@Service
public class LoginService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserAccountRepository accountRepository;

    public boolean verifyCredentials(String username, String password, String selectedRole) {
        // 1. Check credentials in 'users' table
        User user = userRepository.findByUsernameAndPassword(username, password);
        if (user == null) return false;

        // 2. Fetch the account details
        UserAccount account = accountRepository.findByUsername(username);
        
        // 3. Check if account exists, isn't suspended, and role matches
        // We use account.getProfile().getRole() because of the new BCE relationship
        if (account != null && !account.isSuspended() && account.getProfile() != null) {
            return account.getProfile().getRole().equals(selectedRole);
        }

        return false;
    }

    public String getLoginMessage(String username, String password, String selectedRole) {
        User user = userRepository.findByUsernameAndPassword(username, password);
        if (user == null) return "Invalid username or password";

        UserAccount account = accountRepository.findByUsername(username);
        if (account == null) return "Account details not found";
        
        if (account.isSuspended()) return "Account suspended";
        
        // Check if the specific role is correct
        if (!account.getProfile().getRole().equals(selectedRole)) {
            return "Incorrect role selected for this account";
        }

        return "Login successful";
    }

    public String getUserRole(String username) {
        UserAccount account = accountRepository.findByUsername(username);
        return (account != null) ? account.getProfile().getRole() : null;
    }
}