package com.FRA.login_system;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogoutController {
     @PostMapping("/api/logout")
    public String requestLogout() {
        return "Logged out successfully";
    }
    
}
