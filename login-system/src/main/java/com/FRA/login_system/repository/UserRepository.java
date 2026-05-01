package com.FRA.login_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.FRA.login_system.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsernameAndPassword(String username, String password);
}
