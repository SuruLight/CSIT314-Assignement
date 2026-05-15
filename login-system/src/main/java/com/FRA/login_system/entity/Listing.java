package com.FRA.login_system.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "listings")
public class Listing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int listingID;

    private String title;
    private String description;
    private String category;
    private double targetAmount;
    private String status;

    public Listing() {}

    public int getListingID() { return listingID; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public String getCategory() { return category; }
    public double getTargetAmount() { return targetAmount; }
    public String getStatus() { return status; }

    public void setTitle(String title) { this.title = title; }
    public void setDescription(String description) { this.description = description; }
    public void setCategory(String category) { this.category = category; }
    public void setTargetAmount(double targetAmount) { this.targetAmount = targetAmount; }
    public void setStatus(String status) { this.status = status; }

    public String getListingDetails(int listingID) {
        return "Listing ID: " + this.listingID + ", Title: " + title +
                ", Description: " + description + ", Category: " + category +
                ", Target Amount: " + targetAmount + ", Status: " + status;
    }

    public boolean searchListings(String keyword) {
    return title.toLowerCase().contains(keyword.toLowerCase())
        || description.toLowerCase().contains(keyword.toLowerCase())
        || category.toLowerCase().contains(keyword.toLowerCase())
        || status.toLowerCase().contains(keyword.toLowerCase());
    }
}