package com.FRA.login_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.FRA.login_system.entity.SavedListing;

public interface SavedListingRepository extends JpaRepository<SavedListing, Integer> {

    SavedListing findByListingID(int listingID);
}