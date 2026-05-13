package com.FRA.login_system.service.ListingService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FRA.login_system.entity.Listing;
import com.FRA.login_system.repository.ListingRepository;

@Service
public class SearchListingsService {

    @Autowired
    private ListingRepository listingRepository;

    public List<Listing> searchListings(String keyword) {
        return listingRepository
            .findByTitleContainingIgnoreCaseOrDescriptionContainingIgnoreCaseOrCategoryContainingIgnoreCase(
                keyword,
                keyword,
                keyword
            );
    }
}