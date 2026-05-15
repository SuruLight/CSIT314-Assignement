package com.FRA.login_system.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "fra")
public class FRA {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int fraId;
    private String fraName;
    private int totalViews;
    private int shortlistCount;
    private String category;
    private String status;
    private LocalDate completedDate;

    private String donorList;
    private String donationAmounts;
    private String donationDates;

    public FRA() {}

    public int getFraId() {return fraId;}
    public String getFraName() {return fraName;}
    public int getTotalViews() {return totalViews;}
    public int getShortlistCount() {return shortlistCount;}
    public String getCategory() {return category;}
    public String getStatus() {return status;}
    public LocalDate getCompletedDate() {return completedDate;}
    public String getDonorList() {return donorList;}
    public String getDonationAmounts() {return donationAmounts;}
    public String getDonationDates() {return donationDates;}

    public void setFraId(int fraId) {this.fraId = fraId;}
    public void setFraName(String fraName) {this.fraName = fraName;}
    public void setTotalViews(int totalViews) {this.totalViews = totalViews;}
    public void setShortlistCount(int shortlistCount) {this.shortlistCount = shortlistCount;}
    public void setCategory(String category) {this.category = category;}
    public void setStatus(String status) {this.status = status;}
    public void setCompletedDate(LocalDate completedDate) {this.completedDate = completedDate;}
    public void setDonorList(String donorList) {this.donorList = donorList;}
    public void setDonationAmounts(String donationAmounts) {this.donationAmounts = donationAmounts;}
    public void setDonationDates(String donationDates) {this.donationDates = donationDates;}

    public String getFRAList() {
        return "FRA ID: " + fraId + ", FRA Name: " + fraName + ", Total Views: " + totalViews;
    }

    public String getFRAInfo() {
        return "FRA ID: " + fraId + ", FRA Name: " + fraName + ", View Count: " + totalViews + ", Shortlist Count: " + shortlistCount;
    }

    public String searchCompletedFRA(String cat, LocalDate datePeriod) {
        return "FRA ID: " + fraId +
            ", FRA Name: " + fraName +
            ", Category: " + category +
            ", Status: " + status +
            ", Completed Date: " + completedDate +
            ", Total Views: " + totalViews;
    }

    public String getFRADonationHistory() {
    return "FRA ID: " + fraId +
           ", FRA Name: " + fraName +
           ", Donors: " + donorList +
           ", Donation Amounts: " + donationAmounts +
           ", Donation Dates: " + donationDates;
    }
}