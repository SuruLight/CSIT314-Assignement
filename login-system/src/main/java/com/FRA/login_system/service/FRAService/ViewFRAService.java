package com.FRA.login_system.service.FRAService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FRA.login_system.entity.FRA;
import com.FRA.login_system.repository.FRARepository;

@Service
public class ViewFRAService {

    @Autowired
    private FRARepository fraRepository;

    public String getFRAInfo(int fraId) {
        FRA fra = fraRepository.findById(fraId).orElse(null);

        if (fra == null) {
            return "FRA not found.";
        }

        return fra.getFRAInfo();
    }
}