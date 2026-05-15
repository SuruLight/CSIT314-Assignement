package com.FRA.login_system.controller.DonationController;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.FRA.login_system.entity.Donation;
import com.FRA.login_system.service.DonationService.SearchDonationHistoryService;

@RestController
@RequestMapping("/api/donee/donations")
@CrossOrigin(origins = "*")
public class SearchDonationHistoryController {

    @Autowired
    private SearchDonationHistoryService searchDonationHistoryService;

    @GetMapping("/search")
    public List<Donation> getFilteredDonationHistory(
            @RequestParam String cat,
            @RequestParam String datePeriod) {

        LocalDate date = LocalDate.parse(datePeriod);

        return searchDonationHistoryService.getFilteredDonationHistory(cat, date);
    }
}