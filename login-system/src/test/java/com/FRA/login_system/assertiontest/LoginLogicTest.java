package com.FRA.login_system.assertiontest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.FRA.login_system.service.LoginService;

@SpringBootTest
public class LoginLogicTest {

    @Autowired
    private LoginService loginService;

    @Test
    public void testLoginLogicFlow() {
        // 1. Test Successful Login (Using your manual 'admin' user)
        boolean success = loginService.verifyCredentials("admin", "Admin@123", "USER_ADMIN");
        assertTrue(success, "Login should succeed for correct admin credentials");

        // 2. Test Role Security (Correct password, but wrong role selected)
        // This tests the dropdown logic in your LoginPage.html
        boolean wrongRole = loginService.verifyCredentials("admin", "Admin@123", "DONEE");
        assertFalse(wrongRole, "Login must fail if the user selects the wrong role");

        // 3. Test Error Messages
        String message = loginService.getLoginMessage("admin", "wrong_pass", "USER_ADMIN");
        assertEquals("Invalid username or password", message);
    }
}