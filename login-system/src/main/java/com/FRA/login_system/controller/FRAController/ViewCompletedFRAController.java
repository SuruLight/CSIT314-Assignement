package com.FRA.login_system.controller.FRAController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.FRA.login_system.service.FRAService.ViewCompletedFRAService;

@RestController
@RequestMapping("/api/fr/fra")
@CrossOrigin(origins = "*")
public class ViewCompletedFRAController {

    @Autowired
    private ViewCompletedFRAService viewCompletedFRAService;

    @GetMapping("/completed/donation-history/{fraId}")
    public String getFRADonationHistory(@PathVariable int fraId) {
        return viewCompletedFRAService.getFRADonationHistory(fraId);
    }
}