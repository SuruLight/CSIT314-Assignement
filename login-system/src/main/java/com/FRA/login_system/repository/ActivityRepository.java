package com.FRA.login_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.FRA.login_system.entity.Activity;

public interface ActivityRepository extends JpaRepository<Activity, Integer> {}