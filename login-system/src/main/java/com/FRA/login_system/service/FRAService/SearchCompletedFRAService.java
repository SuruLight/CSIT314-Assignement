package com.FRA.login_system.service.FRAService;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FRA.login_system.entity.FRA;
import com.FRA.login_system.repository.FRARepository;

@Service
public class SearchCompletedFRAService {

    @Autowired
    private FRARepository fraRepository;

    public List<FRA> searchCompletedFRA(String cat, LocalDate datePeriod) {
        return fraRepository.findByCategoryContainingIgnoreCaseAndStatusIgnoreCaseAndCompletedDate(
            cat,
            "Completed",
            datePeriod
        );
    }
}