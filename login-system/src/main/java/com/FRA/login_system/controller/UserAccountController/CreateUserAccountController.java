package com.FRA.login_system.controller.UserAccountController;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.FRA.login_system.service.UserAccountService.CreateUserAccountService;

@RestController
@RequestMapping("/api/admin/users")
@CrossOrigin(origins = "*")
public class CreateUserAccountController {

    @Autowired
    private CreateUserAccountService createUserAccountService;

    @PostMapping("/create")
    public boolean createUserAccount(@RequestBody Map<String, String> request) {
        // These keys must match the JSON keys sent from the HTML script
        return createUserAccountService.createUserAccount(
            request.get("userName"),
            request.get("role"),
            request.get("permissions"),
            request.get("password"),
            request.get("email")
        );
    }
}