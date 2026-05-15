package com.FRA.login_system.entity;

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

    public FRA() {}

    public int getFraId() {return fraId;}
    public String getFraName() {return fraName;}
    public int getTotalViews() {return totalViews;}
    public int getShortlistCount() {return shortlistCount;}

    public String getFRAList() {
        return "FRA ID: " + fraId + ", FRA Name: " + fraName + ", Total Views: " + totalViews;
    }

    public String getFRAInfo() {
    return "FRA ID: " + fraId + ", FRA Name: " + fraName + ", View Count: " + totalViews + ", Shortlist Count: " + shortlistCount;
    }
}