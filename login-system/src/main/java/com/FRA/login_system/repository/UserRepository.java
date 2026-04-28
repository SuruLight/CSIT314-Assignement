package com.FRA.login_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.FRA.login_system.UserAdmin;

public interface UserRepository extends JpaRepository<UserAdmin, Integer> {
    UserAdmin findByUsernameAndPassword(String username, String password);
}
