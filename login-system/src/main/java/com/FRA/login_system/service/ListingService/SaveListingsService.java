package com.FRA.login_system.service.ListingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FRA.login_system.entity.SavedListing;
import com.FRA.login_system.repository.SavedListingRepository;

@Service
public class SaveListingsService {

    @Autowired
    private SavedListingRepository savedListingRepository;

    public String saveListing(int listingID) {

        SavedListing existingSavedListing =
            savedListingRepository.findByListingID(listingID);

        if (existingSavedListing != null) {
            return existingSavedListing.checkSavedStatus(listingID);
        }

        SavedListing savedListing = new SavedListing();

        String result = savedListing.saveListing(listingID);

        savedListingRepository.save(savedListing);

        return result;
    }
}