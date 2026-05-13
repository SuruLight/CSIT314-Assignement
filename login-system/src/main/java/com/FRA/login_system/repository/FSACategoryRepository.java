package com.FRA.login_system.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.FRA.login_system.entity.FSACategory;

public interface FSACategoryRepository extends JpaRepository<FSACategory, Integer> {
    FSACategory findByCatName(String catName);

    List<FSACategory> findByCatNameContainingIgnoreCaseOrCatDescContainingIgnoreCase(
        String catName,
        String catDesc
    );
}   