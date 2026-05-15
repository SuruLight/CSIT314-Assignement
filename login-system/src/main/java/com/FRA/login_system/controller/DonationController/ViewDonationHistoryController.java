package com.FRA.login_system.controller.DonationController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.FRA.login_system.entity.Donation;
import com.FRA.login_system.service.DonationService.ViewDonationHistoryService;

@RestController
@RequestMapping("/api/donee/donations")
@CrossOrigin(origins = "*")
public class ViewDonationHistoryController {

    @Autowired
    private ViewDonationHistoryService viewDonationHistoryService;

    @GetMapping("/history")
    public List<Donation> getDonationHistory() {
        return viewDonationHistoryService.getDonationHistory();
    }
}