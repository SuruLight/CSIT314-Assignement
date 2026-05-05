package com.FRA.login_system.controller;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.FRA.login_system.service.LoginService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class LoginController {

    @Autowired
    private LoginService loginService; // Now using Service instead of Repository

    @PostMapping("/login")
    public Map<String, Object> validateLogin(@RequestBody Map<String, String> request) {
        boolean success = loginService.authenticate(request.get("username"), request.get("password"));

        Map<String, Object> response = new HashMap<>();
        response.put("success", success);
        response.put("message", success ? "Login successful" : "Invalid credentials");
        return response;
    }
}