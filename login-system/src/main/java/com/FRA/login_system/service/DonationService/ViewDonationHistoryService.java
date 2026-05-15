package com.FRA.login_system.service.DonationService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FRA.login_system.entity.Donation;
import com.FRA.login_system.repository.DonationRepository;

@Service
public class ViewDonationHistoryService {

    @Autowired
    private DonationRepository donationRepository;

    public List<Donation> getDonationHistory() {
        return donationRepository.findAll();
    }
}