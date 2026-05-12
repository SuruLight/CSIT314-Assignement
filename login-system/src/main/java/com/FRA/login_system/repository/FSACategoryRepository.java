package com.FRA.login_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.FRA.login_system.entity.FSACategory;

public interface FSACategoryRepository extends JpaRepository<FSACategory, Integer> {
    FSACategory findByCatName(String catName);
}   