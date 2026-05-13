package com.FRA.login_system.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.FRA.login_system.entity.Listing;

public interface ListingRepository extends JpaRepository<Listing, Integer> {

    List<Listing> findByTitleContainingIgnoreCaseOrDescriptionContainingIgnoreCaseOrCategoryContainingIgnoreCase(
        String title,
        String description,
        String category
    );
}