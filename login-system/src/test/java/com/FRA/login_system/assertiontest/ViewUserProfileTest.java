package com.FRA.login_system.assertiontest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;



import com.FRA.login_system.entity.UserProfile;
import com.FRA.login_system.service.UserProfileService.ViewUserProfileService;

@SpringBootTest
public class ViewUserProfileTest {

    @Autowired
    private ViewUserProfileService profileService;

    @Test
    public void testGetAllUserProfiles() {
        List<UserProfile> profiles = profileService.getAllUserProfiles();

        assertNotNull(profiles);
        assertFalse(profiles.isEmpty(), "Profile list should not be empty");
        
        // Check if a specific default role exists in the list
        boolean hasAdmin = profiles.stream()
                                   .anyMatch(p -> p.getRole().equals("USER_ADMIN"));
        assertTrue(hasAdmin, "List should contain the USER_ADMIN role");
    }
}
