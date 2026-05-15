package com.FRA.login_system.service.DonationService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FRA.login_system.entity.Donation;
import com.FRA.login_system.repository.DonationRepository;

@Service
public class SearchDonationHistoryService {

    @Autowired
    private DonationRepository donationRepository;

    public List<Donation> getFilteredDonationHistory(String cat, LocalDate datePeriod) {
        LocalDateTime start = datePeriod.atStartOfDay();
        LocalDateTime end = datePeriod.atTime(23, 59, 59);

        return donationRepository.findByCategoryContainingIgnoreCaseAndDonationDateBetween(
            cat,
            start,
            end
        );
    }
}