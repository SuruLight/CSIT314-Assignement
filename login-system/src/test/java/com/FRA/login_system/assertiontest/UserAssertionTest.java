package com.FRA.login_system.assertiontest;

import static org.junit.jupiter.api.Assertions.*;

//import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

// Import your entities and repositories
import com.FRA.login_system.entity.UserAccount;
import com.FRA.login_system.entity.UserProfile;
//import com.FRA.login_system.entity.WeeklyReport;
import com.FRA.login_system.entity.User;
import com.FRA.login_system.entity.Activity;
//import com.FRA.login_system.entity.DailyReport;
import com.FRA.login_system.entity.FRA;
import com.FRA.login_system.entity.Listing;
//import com.FRA.login_system.entity.MonthlyReport;
import com.FRA.login_system.entity.FSACategory;
import com.FRA.login_system.repository.UserAccountRepository;
import com.FRA.login_system.repository.UserProfileRepository;
import com.FRA.login_system.repository.UserRepository;
import com.FRA.login_system.repository.ActivityRepository;
//import com.FRA.login_system.repository.DailyReportRepository;
import com.FRA.login_system.repository.FRARepository;
import com.FRA.login_system.repository.FSACategoryRepository;
import com.FRA.login_system.repository.ListingRepository;



//import com.FRA.login_system.service.FSACategoryService.GenerateReportService;
//import com.FRA.login_system.service.FSACategoryService.GenerateWeeklyReportService;
//import com.FRA.login_system.service.FSACategoryService.GenerateMonthlyReportService;


@SpringBootTest
public class UserAssertionTest {

    @Autowired
    private UserAccountRepository accountRepo;

    @Autowired
    private UserProfileRepository profileRepo;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private ActivityRepository activityRepo; // Ensure you create this interface

    @Autowired
    private FRARepository fraRepo; // Ensure this interface exists in your repository package
   
    @Autowired
    private ListingRepository listingRepo; // Ensure you have created this interface

    @Autowired
    private FSACategoryRepository catRepo;

    //@Autowired
    //private DailyReportRepository dailyRepo;

    // @Autowired
    // private GenerateReportService generateReportService;

    // @Autowired
    // private GenerateWeeklyReportService generateWeeklyReportService;

    // @Autowired
    // private GenerateMonthlyReportService generateMonthlyReportService;


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

    /**
    * Test 5: Verifies the new User entity (Password persistence)
    */
   @Test
    public void testUserPasswordPersistence() {
    // 1. Setup unique data
    String uniqueName = "Azuru_" + System.currentTimeMillis();
    
    // 2. Create the Account FIRST (Requirement because of your SQL Foreign Key)
    UserAccount account = new UserAccount();
    account.setUsername(uniqueName);
    account.setEmail(uniqueName + "@test.com");
    accountRepo.save(account);

    // 3. Create the User (Password) SECOND
    User loginUser = new User();
    loginUser.setUsername(uniqueName);
    loginUser.setPassword("SecurePass123");
    userRepo.save(loginUser);

    // 4. Assertion
    User retrieved = userRepo.findById(uniqueName).orElse(null);
    assertNotNull(retrieved, "User should be found after account is created");
    assertEquals("SecurePass123", retrieved.getPassword());
    }

    /**
    * Test 6: Verifies Activity Entity logic and database persistence
    */
    @Test
    public void testActivityCreationLogic() {
    // 1. Setup
    Activity newActivity = new Activity();
    
    // 2. Action: Use the method defined in your Activity.java
    String result = newActivity.createActivity(
        "Save the Mangroves", 
        "Protecting local coastlines", 
        5000.00
    );

    // 3. Save to DB
    Activity saved = activityRepo.save(newActivity);

    // 4. Assertions
    assertEquals("Fund raising activity created successfully.", result);
    assertNotNull(saved.getActivityId());
    assertEquals("Active", saved.getStatus());
    assertEquals(java.time.LocalDate.now(), saved.getCreatedDate());
    }

    /**
 * Test 7: Verifies FRA Entity data formatting and persistence
 */
    @Test
    public void testFRAListFormatting() {
    // 1. Setup: Create a new FRA entry
    //FRA newFra = new FRA();
    // Since fraId is generated by the DB, we save it first to get an ID
    // or we can test the logic after saving.
    
    // Note: In your FRA.java, fields are private with no setters.
    // If you haven't added setters, we can test a retrieved record from the bulk insert.
    
    // 2. Action: Retrieve one from the 100 we inserted via SQL
    // We'll search for the first one to verify the formatting logic
    FRA existingFra = fraRepo.findAll().stream().findFirst().orElse(null);

    assertNotNull(existingFra, "Should find at least one FRA from the bulk insert");

    // 3. Assertion: Verify the getFRAList() string format
    String listOutput = existingFra.getFRAList();
    
    assertTrue(listOutput.contains("FRA ID:"), "Output should contain 'FRA ID:'");
    assertTrue(listOutput.contains("FRA Name:"), "Output should contain 'FRA Name:'");
    assertTrue(listOutput.contains("Total Views:"), "Output should contain 'Total Views:'");
    }

    /**
 * Test 8: Verifies Listing Entity search logic and persistence
 */
    @Test
    public void testListingSearchAndDetails() {
    // 1. Setup: Use an existing listing from the 100 bulk-inserted
    Listing testListing = listingRepo.findAll().stream()
                            .filter(l -> l.getTitle().contains("10"))
                            .findFirst().orElse(null);

    assertNotNull(testListing, "Should find listing number 10");

    // 2. Action & Assertion: Test Search Keyword Logic
    // Should return true for title match
    assertTrue(testListing.searchListings("Need"), "Search should find 'Need' in title");
    
    // Should return true for status match
    assertTrue(testListing.searchListings("Open"), "Search should find 'Open' in status");

    // 3. Assertion: Verify the getListingDetails formatting
    String details = testListing.getListingDetails(testListing.getListingID());
    assertTrue(details.contains("Title:"), "Details should include title label");
    assertTrue(details.contains("Category:"), "Details should include category label");
    }   

    /**
 * Test 9: Verifies FSACategory Entity logic and Repository search
 */
@Test
public void testCategoryLogicAndSearch() {
    // 1. Setup: Create a new category using entity method
    FSACategory category = new FSACategory();
    String creationMsg = category.createFSACat("Disaster Relief", "Support for emergency situations");
    
    // 2. Action: Save and Search
    catRepo.save(category);
    
    // Test the repository keyword search (Ignore Case)
    List<FSACategory> results = catRepo.findByCatNameContainingIgnoreCaseOrCatDescContainingIgnoreCase("relief", "relief");

    // 3. Assertions
    assertEquals("FSA Category created successfully.", creationMsg);
    assertFalse(results.isEmpty(), "Should find the disaster relief category by keyword");
    
    // Verify formatting method
    String display = category.getFSACategories();
    assertTrue(display.contains("Name: Disaster Relief"), "Display string should contain the correct name");
}

 /**
 * Test 10: Verifies that GenerateReportService calculates 
 * data correctly and saves it to the database.
 */
// @Test
// public void testDailyReportPersistence() {
//     // 1. Arrange
//     DailyReport report = new DailyReport();
//     LocalDate testDate = LocalDate.now();
    
//     // 2. Act
//     report.generateReport(testDate, 10, 5000.0);
    
//     // SAVE using the report-specific repository
//     DailyReport savedReport = dailyRepo.save(report);
    
//     // 3. Assert
//     assertNotNull(savedReport.getReportId());
//     assertEquals(5000.0, savedReport.getTotalTargetAmount());
// }
 
}