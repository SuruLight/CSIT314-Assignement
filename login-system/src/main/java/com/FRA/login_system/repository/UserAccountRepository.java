package com.FRA.login_system.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.FRA.login_system.entity.UserAccount;

public interface UserAccountRepository extends JpaRepository<UserAccount, Integer> {
    
    UserAccount findByUsername(String username);

    // This query finds users who match the keyword AND are NOT suspended 
    // at BOTH the account level and the profile level.
    @Query("SELECT u FROM UserAccount u WHERE " +
           "(LOWER(u.username) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
           " LOWER(u.email) LIKE LOWER(CONCAT('%', :keyword, '%'))) AND " +
           "u.suspended = false AND " +
           "u.profile.suspended = false")
    List<UserAccount> searchActiveUsers(@Param("keyword") String keyword);
}

