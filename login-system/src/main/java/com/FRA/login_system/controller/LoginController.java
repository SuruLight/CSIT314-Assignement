package com.FRA.login_system.controller;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.FRA.login_system.service.LoginService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public Map<String, Object> validateLogin(@RequestBody Map<String, String> request) {
        String username = request.get("username");
        String password = request.get("password");
        String role = request.get("role");

        boolean success = loginService.verifyCredentials(username, password, role);
        String message = loginService.getLoginMessage(username, password, role);

        Map<String, Object> response = new HashMap<>();
        response.put("success", success);
        response.put("message", message);
        // Fetch the actual role from the DB to send back to the frontend
        response.put("role", loginService.getUserRole(username));

        return response;
    }
}