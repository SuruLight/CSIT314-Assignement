package com.FRA.login_system.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "donations")
public class Donation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int donationId;

    private String doneeName;
    private String fraName;
    private double donationAmount;
    private LocalDateTime donationDate;
    private String category;
    private double targetAmount;

    public Donation() {}

    public int getDonationId() { return donationId; }
    public String getDoneeName() { return doneeName; }
    public String getFraName() { return fraName; }
    public double getDonationAmount() { return donationAmount; }
    public LocalDateTime getDonationDate() { return donationDate; }
    public String getCategory() { return category; }
    public double getTargetAmount() { return targetAmount; }

    public void setCategory(String category) { this.category = category; }
    public void setTargetAmount(double targetAmount) { this.targetAmount = targetAmount; }

    public String getDonationHistory() {
        return "FRA: " + fraName +
               ", Amount: " + donationAmount +
               ", Date: " + donationDate;
    }

    public String getFilteredDonationHistory() {
        double progressPercentage = 0;

        if (targetAmount > 0) {
            progressPercentage = (donationAmount / targetAmount) * 100;
        }

        return "FRA: " + fraName +
            ", Amount Donated: " + donationAmount +
            ", Progress: " + progressPercentage + "%";
    }
}