package com.FRA.login_system.controller.ListingController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.FRA.login_system.entity.Listing;
import com.FRA.login_system.service.ListingService.ViewListingsService;

@RestController
@RequestMapping("/api/donee/listings")
@CrossOrigin(origins = "*")
public class ViewListingsController {

    @Autowired
    private ViewListingsService viewListingsService;

    @GetMapping
    public List<Listing> getListings() {
        return viewListingsService.getListings();
    }

    @GetMapping("/{listingID}")
    public String getListingDetails(@PathVariable int listingID) {
        return viewListingsService.getListingDetails(listingID);
    }
}