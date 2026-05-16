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

    /**
     * Test Case 1: Verification Flow for System Administrators (USER_ADMIN)
     * Validates manual static profile 'admin' and bulk generated accounts.
     */
    @Test
    public void testAdminUserLoginLogic() {
        // 1. Success validation for manual seed admin
        boolean manualAdminSuccess = loginService.verifyCredentials("admin", "Admin@123", "USER_ADMIN");
        assertTrue(manualAdminSuccess, "Login must succeed for manual admin credentials with USER_ADMIN role");

        // 2. Success validation for a generated bulk admin profile (i % 4 = 0)
        boolean bulkAdminSuccess = loginService.verifyCredentials("user_4", "password4", "USER_ADMIN");
        assertTrue(bulkAdminSuccess, "Login must succeed for an automated bulk-inserted USER_ADMIN account");

        // 3. Dropdown Cross-Role Security mismatch check
        boolean invalidRoleSelection = loginService.verifyCredentials("admin", "Admin@123", "DONEE");
        assertFalse(invalidRoleSelection, "Security block should reject an admin attempting login as a DONEE");
    }

    /**
     * Test Case 2: Verification Flow for Charity Recipients (DONEE)
     * Validates manual account 'AAA' and automated dynamic indices.
     */
    @Test
    public void testDoneeUserLoginLogic() {
        // 1. Success validation for manual seed profile
        boolean manualDoneeSuccess = loginService.verifyCredentials("AAA", "AAA", "DONEE");
        assertTrue(manualDoneeSuccess, "Login must succeed for manual donee credentials with DONEE role");

        // 2. Success validation for a generated bulk donee profile (i % 4 = 1)
        boolean bulkDoneeSuccess = loginService.verifyCredentials("user_1", "password1", "DONEE");
        assertTrue(bulkDoneeSuccess, "Login must succeed for an automated bulk-inserted DONEE account");

        // 3. Dropdown Cross-Role Security mismatch check
        boolean invalidRoleSelection = loginService.verifyCredentials("AAA", "AAA", "FR");
        assertFalse(invalidRoleSelection, "Security block should reject a donee attempting login as an FR");
    }

    /**
     * Test Case 3: Verification Flow for Internal Managers (PLATFORM_MANAGEMENT)
     * Validates manual account 'CCC' and automated management profiles.
     */
    @Test
    public void testPlatformManagementUserLoginLogic() {
        // 1. Success validation for manual seed profile
        boolean manualManagerSuccess = loginService.verifyCredentials("CCC", "CCC", "PLATFORM_MANAGEMENT");
        assertTrue(manualManagerSuccess, "Login must succeed for manual manager credentials with PLATFORM_MANAGEMENT role");

        // 2. Success validation for a generated bulk management profile (i % 4 = 2)
        boolean bulkManagerSuccess = loginService.verifyCredentials("user_2", "password2", "PLATFORM_MANAGEMENT");
        assertTrue(bulkManagerSuccess, "Login must succeed for an automated bulk-inserted PLATFORM_MANAGEMENT account");

        // 3. Dropdown Cross-Role Security mismatch check
        boolean invalidRoleSelection = loginService.verifyCredentials("CCC", "CCC", "USER_ADMIN");
        assertFalse(invalidRoleSelection, "Security block should reject an operations manager attempting login as an Admin");
    }

    /**
     * Test Case 4: Verification Flow for Fund Raisers (FR)
     * Validates manual account 'DDD' and automated campaign manager profiles.
     */
    @Test
    public void testFundRaiserUserLoginLogic() {
        // 1. Success validation for manual seed profile
        boolean manualRaiserSuccess = loginService.verifyCredentials("DDD", "DDD", "FR");
        assertTrue(manualRaiserSuccess, "Login must succeed for manual fundraiser credentials with FR role");

        // 2. Success validation for a generated bulk fundraiser profile (i % 4 = 3)
        boolean bulkRaiserSuccess = loginService.verifyCredentials("user_3", "password3", "FR");
        assertTrue(bulkRaiserSuccess, "Login must succeed for an automated bulk-inserted FR account");

        // 3. Dropdown Cross-Role Security mismatch check
        boolean invalidRoleSelection = loginService.verifyCredentials("DDD", "DDD", "PLATFORM_MANAGEMENT");
        assertFalse(invalidRoleSelection, "Security block should reject a fundraiser attempting login as PLATFORM_MANAGEMENT");
    }

    /**
     * Test Case 5: Universal Validation for Global System Failure and Error Handling Messages
     */
    @Test
    public void testInvalidCredentialsErrorMessages() {
        // 1. Incorrect password check
        String badPasswordMsg = loginService.getLoginMessage("admin", "wrong_pass", "USER_ADMIN");
        assertEquals("Invalid username or password", badPasswordMsg, "Should return default rejection payload for a bad password");

        // 2. Non-existent identifier registration lookup check
        String missingUserMsg = loginService.getLoginMessage("ghost_user", "password123", "DONEE");
        assertEquals("Invalid username or password", missingUserMsg, "System error messages shouldn't leak user existence context metrics");
    }
}