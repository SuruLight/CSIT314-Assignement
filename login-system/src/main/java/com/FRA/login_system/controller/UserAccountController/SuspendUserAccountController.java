package com.FRA.login_system.controller.UserAccountController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.FRA.login_system.entity.UserAccount;
import com.FRA.login_system.service.UserAccountService.SuspendUserAccountService;

@RestController
@RequestMapping("/api/admin/users")
@CrossOrigin(origins = "*")
public class SuspendUserAccountController {

    @Autowired
    private SuspendUserAccountService suspendAccountService;

    // This handles the "Suspend" button (true)
    @PutMapping("/{userID}/suspend")
    public UserAccount suspendUser(@PathVariable int userID) {
        return suspendAccountService.updateStatus(true, userID);
    }

    // This handles the "Unsuspend" button (false)
    @PutMapping("/{userID}/unsuspend")
    public UserAccount unsuspendUser(@PathVariable int userID) {
        return suspendAccountService.updateStatus(false, userID);
    }
}