package com.FRA.login_system.service.FRAService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FRA.login_system.entity.FRA;
import com.FRA.login_system.repository.FRARepository;

@Service
public class ViewCompletedFRAService {

    @Autowired
    private FRARepository fraRepository;

    public String getFRADonationHistory(int fraId) {
        FRA fra = fraRepository.findById(fraId).orElse(null);

        if (fra == null) {
            return "No Matches Found.";
        }

        return fra.getFRADonationHistory();
    }
}