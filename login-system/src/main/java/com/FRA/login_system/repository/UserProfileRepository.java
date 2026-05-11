package com.FRA.login_system.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.FRA.login_system.entity.UserProfile;

public interface UserProfileRepository extends JpaRepository<UserProfile, String> {
    List<UserProfile> findByRoleContainingIgnoreCaseOrDescriptionContainingIgnoreCase(String role, String description);
}
