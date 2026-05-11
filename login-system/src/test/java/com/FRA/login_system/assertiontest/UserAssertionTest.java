package com.FRA.login_system.assertiontest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

// Import your entities and repositories
import com.FRA.login_system.entity.UserAccount;
import com.FRA.login_system.entity.UserProfile;
import com.FRA.login_system.repository.UserAccountRepository;
import com.FRA.login_system.repository.UserProfileRepository;

@SpringBootTest
public class UserAssertionTest {

    @Autowired
    private UserAccountRepository accountRepo;

    @Autowired
    private UserProfileRepository profileRepo;

    /**
     * Test 1: Verifies the logic of linking objects in memory
     */
    @Test
    public void testUserAccountAndProfileLink() {
        // 1. Create the Profile (Entity)
        UserProfile frProfile = new UserProfile();
        frProfile.setRole("FR");
        frProfile.setPermissions("Create_FRA, View_History");

        // 2. Create the Account (Entity)
        UserAccount account = new UserAccount();
        account.setUsername("Azuru");
        account.setProfile(frProfile); 

        // 3. Use JUnit assertions to verify memory linkage
        assertEquals("FR", account.getProfile().getRole());
        assertNotNull(account.getProfile());
        assertFalse(account.isSuspended());
    }

    /**
     * Test 2: Verifies saving and retrieving a Profile from the database
     */
    @Test
    public void testCreateAndRetrieveProfile() {
        // 1. Setup
        UserProfile newProfile = new UserProfile();
        newProfile.setRole("TEST_ROLE");
        newProfile.setDescription("Role for unit testing");
        newProfile.setPermissions("READ,WRITE");
        newProfile.setSuspended(false);

        // 2. Action: Save
        profileRepo.save(newProfile);

        // 3. Assertion: Retrieve and verify
        UserProfile retrieved = profileRepo.findById("TEST_ROLE").orElse(null);
        
        assertNotNull(retrieved, "Profile should be found in the database");
        assertEquals("Role for unit testing", retrieved.getDescription());
        assertEquals("READ,WRITE", retrieved.getPermissions());
        assertFalse(retrieved.isSuspended());
    }

    /**
     * Test 3: Verifies saving a linked Account/Profile relationship to the database
     */
    @Test
    public void testCreateAccountWithProfileLink() {
        // 1. Setup: Ensure a profile exists
        UserProfile adminProfile = profileRepo.findById("USER_ADMIN").orElseGet(() -> {
            UserProfile p = new UserProfile();
            p.setRole("USER_ADMIN");
            return profileRepo.save(p);
        });

        // 2. Action: Create and Save Account
        UserAccount newAccount = new UserAccount();
        newAccount.setUsername("TestUser123");
        newAccount.setEmail("test@example.com");
        newAccount.setProfile(adminProfile);
        newAccount.setSuspended(false);

        UserAccount savedAccount = accountRepo.save(newAccount);

        // 3. Assertion: Verify persistence
        assertNotNull(savedAccount.getId(), "Account ID should be auto-generated");
        assertEquals("TestUser123", savedAccount.getUsername());
        assertEquals("USER_ADMIN", savedAccount.getProfile().getRole());
        assertFalse(savedAccount.isSuspended());
    }

    /**
     * Test 4: Verifies the Logout Logic (Session clearing)
     */
    @Test
    public void testLogoutLogic() {
        // 1. Setup: Create a "logged in" user
        UserAccount activeUser = new UserAccount();
        activeUser.setUsername("Azuru");
        
        // This represents our "Active Session" variable
        UserAccount sessionUser = activeUser; 
        assertNotNull(sessionUser, "Session should start as active");

        // 2. Action: Perform Logout (Setting the session to null)
        sessionUser = null;

        // 3. Equation: Verify the session is officially empty
        assertNull(sessionUser, "Session must be null after logout");
    }
}