package com.FRA.login_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.FRA.login_system.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> { 
    User findByUsernameAndPassword(String username, String password);
}
