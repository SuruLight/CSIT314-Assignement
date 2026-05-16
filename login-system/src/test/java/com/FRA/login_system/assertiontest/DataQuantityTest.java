package com.FRA.login_system.assertiontest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

// Import all required repositories
import com.FRA.login_system.repository.UserRepository;
import com.FRA.login_system.repository.UserAccountRepository;
import com.FRA.login_system.repository.UserProfileRepository;
import com.FRA.login_system.repository.ActivityRepository;
import com.FRA.login_system.repository.FRARepository;
import com.FRA.login_system.repository.ListingRepository;
import com.FRA.login_system.repository.FSACategoryRepository;
import com.FRA.login_system.repository.DailyReportRepository;
import com.FRA.login_system.repository.WeeklyReportRepository;
import com.FRA.login_system.repository.MonthlyReportRepository;

@SpringBootTest
public class DataQuantityTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserAccountRepository userAccountRepository;

    @Autowired
    private UserProfileRepository userProfileRepository;

    @Autowired
    private ActivityRepository activityRepository;

    @Autowired
    private FRARepository fraRepository;

    @Autowired
    private ListingRepository listingRepository;

    @Autowired
    private FSACategoryRepository fsaCategoryRepository;

    @Autowired
    private DailyReportRepository dailyReportRepository;

    @Autowired
    private WeeklyReportRepository weeklyReportRepository;

    @Autowired
    private MonthlyReportRepository monthlyReportRepository;

    @Test
    public void testDatabaseHasExpectedRecordQuantities() {
        
        // 1. Verify Core Profile Configurations (4 Base System Roles)
        long profileCount = userProfileRepository.count();
        assertTrue(profileCount >= 4, "System should contain at least the 4 defined core user roles");

        // 2. Verify User Authentication Profiles (5 Manual Records + 100 Bulk Iterated Records)
        long totalAccounts = userAccountRepository.count();
        assertEquals(105, totalAccounts, "User accounts table should have exactly 105 total records");

        long totalUsers = userRepository.count();
        assertEquals(105, totalUsers, "Users password table should align with accounts at 105 records");

        // 3. Verify Operational Entities (100 Bulk Iterated Loop Records per table)
        long totalActivities = activityRepository.count();
        assertEquals(100, totalActivities, "Activities tracker table should have exactly 100 mock items");

        long totalFraEntries = fraRepository.count();
        assertEquals(100, totalFraEntries, "FRA Campaign matrix table should have exactly 100 mock items");

        long totalListings = listingRepository.count();
        assertEquals(100, totalListings, "Public listings index table should have exactly 100 mock items");

        long totalCategories = fsaCategoryRepository.count();
        assertEquals(100, totalCategories, "FSA Category domain mappings should have exactly 100 mock items");

        // 4. Verify Generated Analytical Reports (100 Loop Records generated across timelines)
        long dailyReportCount = dailyReportRepository.count();
        assertTrue(dailyReportCount >= 100, "Daily report analytics compilation should capture at least 100 operational days");

        long weeklyReportCount = weeklyReportRepository.count();
        assertEquals(100, weeklyReportCount, "Weekly metrics ledger compilation should track exactly 100 analytical weeks");

        long monthlyReportCount = monthlyReportRepository.count();
        assertEquals(100, monthlyReportCount, "Monthly metrics ledger compilation should track exactly 100 analytical months");
    }
}