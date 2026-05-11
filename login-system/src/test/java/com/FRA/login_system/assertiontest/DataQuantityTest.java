package com.FRA.login_system.assertiontest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.FRA.login_system.repository.UserRepository;

@SpringBootTest
public class DataQuantityTest {
    @Autowired
    private UserRepository accountRepo;

    @Test
    public void testDatabaseHas100Records() {
        // 1. Action: Get the count from the database
        long totalRecords = accountRepo.count();

        // 2. Equation (Assert): Verify it matches exactly 100
        // If you inserted more (like the 5 test users), change 100 to 105
        assertEquals(105, totalRecords, "The database should have 105 total records");
    }
}
