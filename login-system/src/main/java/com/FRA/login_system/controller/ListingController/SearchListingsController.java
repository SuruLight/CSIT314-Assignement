package com.FRA.login_system.controller.ListingController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.FRA.login_system.entity.Listing;
import com.FRA.login_system.service.ListingService.SearchListingsService;

@RestController
@RequestMapping("/api/donee/listings")
@CrossOrigin(origins = "*")
public class SearchListingsController {

    @Autowired
    private SearchListingsService searchListingsService;

    @GetMapping("/search")
    public List<Listing> searchListings(@RequestParam String keyword) {
        return searchListingsService.searchListings(keyword);
    }
}