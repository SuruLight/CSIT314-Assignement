package com.FRA.login_system;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.FRA.login_system.repository.UserRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public Map<String, Object> validateLogin(@RequestBody Map<String, String> request) {

        String username = request.get("username");
        String password = request.get("password");

        UserAdmin user = userRepository.findByUsernameAndPassword(username, password);

        boolean loginStatus = (user != null);

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