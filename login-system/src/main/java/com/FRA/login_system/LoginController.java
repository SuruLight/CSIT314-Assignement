package com.FRA.login_system;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin // allows frontend to call backend
public class LoginController {

    @PostMapping("/login")
    public Map<String, Object> validateLogin(@RequestBody Map<String, String> request) {

        String username = request.get("username");
        String password = request.get("password");

        UserAdmin user = new UserAdmin(username, password);

        boolean loginStatus = user.verifyCredentials();

        Map<String, Object> response = new HashMap<>();
        response.put("success", loginStatus);

        if (loginStatus) {
            response.put("message", "Login successful");
        } else {
            response.put("message", "Invalid credentials");
        }

        return response;
    }
}