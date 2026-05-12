package com.FRA.login_system.assertiontest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.FRA.login_system.entity.UserAccount;
import com.FRA.login_system.entity.UserProfile;
import com.FRA.login_system.service.UserAccountService.SuspendUserAccountService;
import com.FRA.login_system.service.UserProfileService.SuspendUserProfileService;

@SpringBootTest
public class StatusLogicTest {

    @Autowired
    private SuspendUserAccountService accountService;

    @Autowired
    private SuspendUserProfileService profileService;

    @Test
    public void testAccountSuspensionFlow() {
        // 1. Action: Suspend User ID 1 (e.g., admin)
        UserAccount suspended = accountService.updateStatus(true, 1);
        assertNotNull(suspended);
        assertTrue(suspended.isSuspended(), "Account should be suspended");

        // 2. Action: Unsuspend User ID 1
        UserAccount active = accountService.updateStatus(false, 1);
        assertNotNull(active);
        assertFalse(active.isSuspended(), "Account should be active again");
    }

    @Test
    public void testProfileSuspension() {
        // Action: Suspend the 'FR' role
        UserProfile profile = profileService.suspendProfile("FR");
        
        assertNotNull(profile);
        assertEquals("FR", profile.getRole());
        assertTrue(profile.isSuspended(), "The entire FR profile should be suspended");
    }
}
