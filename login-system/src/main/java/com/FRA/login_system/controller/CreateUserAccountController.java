package com.FRA.login_system.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.FRA.login_system.service.CreateUserAccountService;

@RestController
@RequestMapping("/api/admin/users")
@CrossOrigin(origins = "*")
public class CreateUserAccountController {

    @Autowired
    private CreateUserAccountService createUserAccountService;

    @PostMapping("/create")
    public boolean createUserAccount(@RequestBody Map<String, String> request) {
        String userName = request.get("userName");
        String role = request.get("role");
        String permissions = request.get("permissions");
        String password = request.get("password");
        String email = request.get("email");

        return createUserAccountService.createUserAccount(
            userName,
            role,
            permissions,
            password,
            email
        );
    }
}