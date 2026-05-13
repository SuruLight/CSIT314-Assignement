package com.FRA.login_system.controller.ListingController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.FRA.login_system.service.ListingService.SaveListingsService;

@RestController
@RequestMapping("/api/donee/saved-listings")
@CrossOrigin(origins = "*")
public class SaveListingsController {

    @Autowired
    private SaveListingsService saveListingsService;

    @PostMapping("/save/{listingID}")
    public String saveListing(@PathVariable int listingID) {
        return saveListingsService.saveListing(listingID);
    }
}