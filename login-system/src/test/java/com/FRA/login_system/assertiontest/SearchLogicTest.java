package com.FRA.login_system.assertiontest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.FRA.login_system.entity.UserAccount;
import com.FRA.login_system.entity.UserProfile;
import com.FRA.login_system.service.SearchUserAccountService;
import com.FRA.login_system.service.SearchUserProfileService;
import java.util.List;

@SpringBootTest
public class SearchLogicTest {

    @Autowired
    private SearchUserAccountService searchAccountService;

    @Autowired
    private SearchUserProfileService searchProfileService;

    @Test
    public void testSearchFunctionality() {
        // 1. Test User Account Search (Control Layer logic)
        List<UserAccount> accounts = searchAccountService.searchUser("admin");
        assertFalse(accounts.isEmpty(), "Should find the admin account");
        assertEquals("admin", accounts.get(0).getUsername());

        // 2. Test Case Insensitivity (Sophistication check)
        List<UserAccount> capsSearch = searchAccountService.searchUser("ADMIN");
        assertFalse(capsSearch.isEmpty(), "Search should be case-insensitive");

        // 3. Test User Profile Search
        List<UserProfile> profiles = searchProfileService.searchUser("FR");
        assertFalse(profiles.isEmpty(), "Should find the Fund Raiser profile");
        assertEquals("FR", profiles.get(0).getRole());
    }
}