package com.FRA.login_system.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.FRA.login_system.entity.Donation;

public interface DonationRepository extends JpaRepository<Donation, Integer> {

    List<Donation> findByCategoryContainingIgnoreCaseAndDonationDateBetween(
        String category,
        LocalDateTime startDate,
        LocalDateTime endDate
    );
}