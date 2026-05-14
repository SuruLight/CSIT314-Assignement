package com.FRA.login_system.service.ListingService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FRA.login_system.entity.SavedListing;
import com.FRA.login_system.repository.SavedListingRepository;

@Service
public class SearchSavedListingsService {

    @Autowired
    private SavedListingRepository savedListingRepository;

    public List<SavedListing> searchSavedListings(String keyword) {
        int listingID = Integer.parseInt(keyword);

        SavedListing savedListing = savedListingRepository.findByListingID(listingID);

        List<SavedListing> results = new ArrayList<>();

        if (savedListing != null) {
            results.add(savedListing);
        }

        return results;
    }

    public String getListingDetails(int listingID) {
        SavedListing savedListing = savedListingRepository.findByListingID(listingID);

        if (savedListing == null) {
            return "Saved listing not found.";
        }

        return savedListing.getListingDetails(listingID);
    }
}