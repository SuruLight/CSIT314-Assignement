package com.FRA.login_system.assertiontest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;



import com.FRA.login_system.entity.UserAccount;
import com.FRA.login_system.service.UserAccountService.ViewUserAccountService;

@SpringBootTest
public class ViewUserAccountTest {

    @Autowired
    private ViewUserAccountService viewService;

    @Test
    public void testGetExistingUser() {
        // Assuming ID 1 exists in your test database/H2
        int testId = 1; 
        UserAccount account = viewService.getUser(testId);

        assertNotNull(account, "Account should not be null");
        assertEquals(testId, account.getId());
        assertNotNull(account.getProfile(), "The linked Profile should be loaded");
    }

    @Test
    public void testGetNonExistentUser() {
        // Use an ID that definitely doesn't exist
        UserAccount account = viewService.getUser(9999);
        assertNull(account, "Should return null for non-existent ID");
    }
}
