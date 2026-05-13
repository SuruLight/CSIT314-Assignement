package com.FRA.login_system.service.ListingService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FRA.login_system.entity.Listing;
import com.FRA.login_system.repository.ListingRepository;

@Service
public class ViewListingsService {

    @Autowired
    private ListingRepository listingRepository;

    public List<Listing> getListings() {
        return listingRepository.findAll();
    }

    public String getListingDetails(int listingID) {
        Listing listing = listingRepository.findById(listingID).orElse(null);

        if (listing == null) {
            return "Listing not found.";
        }

        return listing.getListingDetails(listingID);
    }
}