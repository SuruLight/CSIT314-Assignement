package com.FRA.login_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.FRA.login_system.entity.UserAccount;
import com.FRA.login_system.service.ViewUserAccountService;

@RestController
@RequestMapping("/api/admin/users")
@CrossOrigin(origins = "*")
public class ViewUserAccountController {

    @Autowired
    private ViewUserAccountService viewUserAccountService;

    @GetMapping("/view/{userID}")
    public UserAccount getUser(@PathVariable int userID) {
        return viewUserAccountService.getUser(userID);
    }
}