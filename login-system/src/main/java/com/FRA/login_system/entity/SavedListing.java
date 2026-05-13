package com.FRA.login_system.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "saved_listings")
public class SavedListing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int savedId;

    private int listingID;

    private LocalDateTime savedAt;

    public SavedListing() {}

    public String checkSavedStatus(int listingID) {
        if (this.listingID == listingID) {
            return "Listing already saved.";
        }

        return "Listing not saved yet.";
    }

    public String saveListing(int listingID) {
        this.listingID = listingID;
        this.savedAt = LocalDateTime.now();

        return "Listing saved successfully.";
    }

    public int getSavedId() {
        return savedId;
    }

    public int getListingID() {
        return listingID;
    }

    public LocalDateTime getSavedAt() {
        return savedAt;
    }
}