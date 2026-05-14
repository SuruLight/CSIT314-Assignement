package com.FRA.login_system.controller.ListingController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.FRA.login_system.entity.SavedListing;
import com.FRA.login_system.service.ListingService.ViewSavedListingsService;

@RestController
@RequestMapping("/api/donee/saved-listings")
@CrossOrigin(origins = "*")
public class ViewSavedListingsController {

    @Autowired
    private ViewSavedListingsService viewSavedListingsService;

    @GetMapping
    public List<SavedListing> getSavedListings() {
        return viewSavedListingsService.getSavedListings();
    }

    @GetMapping("/{listingID}")
    public String getListingDetails(@PathVariable int listingID) {
        return viewSavedListingsService.getListingDetails(listingID);
    }
}