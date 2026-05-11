package com.FRA.login_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.FRA.login_system.entity.UserAccount;
import com.FRA.login_system.service.SuspendUserAccountService;

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