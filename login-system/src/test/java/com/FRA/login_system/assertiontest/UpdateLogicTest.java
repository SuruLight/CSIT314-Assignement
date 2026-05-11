package com.FRA.login_system.assertiontest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.FRA.login_system.entity.UserAccount;
import com.FRA.login_system.entity.UserProfile;
import com.FRA.login_system.service.UpdateUserAccountService;
import com.FRA.login_system.service.UpdateUserProfileService;

@SpringBootTest
public class UpdateLogicTest {

    @Autowired
    private UpdateUserAccountService updateAccountService;

    @Autowired
    private UpdateUserProfileService updateProfileService;

    @Test
    public void testUpdateUserAccountLogic() {
        // 1. Action: Update an existing user (e.g., 'admin') to have 'UPDATE_USER' permission
        String testUser = "admin";
        String newPermissions = "SEARCH_USER,UPDATE_USER";
        
        UserAccount updatedAccount = updateAccountService.updateUserAccount(testUser, "USER_ADMIN", newPermissions);

        // 2. Equation: Verify the changes were saved
        assertNotNull(updatedAccount);
        assertEquals(newPermissions, updatedAccount.getPermissions(), "Permissions should be updated in the DB");
    }

    @Test
    public void testUpdateUserProfileLogic() {
        // 1. Action: Change the name and permissions of the 'FR' role
        String newName = "Senior Fund Raiser";
        String newPerms = "VIEW_USER,UPDATE_USER";
        
        UserProfile updatedProfile = updateProfileService.updateProfile("FR", newName, newPerms);

        // 2. Equation: Verify the Profile Entity was modified correctly
        assertNotNull(updatedProfile);
        assertEquals(newName, updatedProfile.getProfileName());
        assertEquals(newPerms, updatedProfile.getPermissions());
    }
}
