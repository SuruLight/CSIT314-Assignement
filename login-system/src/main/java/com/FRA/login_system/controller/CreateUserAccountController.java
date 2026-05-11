package com.FRA.login_system.controller;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.FRA.login_system.service.CreateUserAccountService;

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