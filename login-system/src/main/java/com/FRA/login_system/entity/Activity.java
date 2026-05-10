package com.FRA.login_system.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "activities")
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int activityId;

    private String activityName;
    private String description;
    private double targetAmount;

    public Activity() {}

    // CreatedActivity method
    public String createActivity(String activityName, String description,double targetAmount) {
        this.activityName = activityName;
        this.description = description;
        this.targetAmount = targetAmount;

        return "Fund raising activity created successfully.";
    }

    // ViewActivity method
    public String viewActivity() {
        return "Activity ID: " + activityId +
            ", Name: " + activityName +
            ", Description: " + description +
            ", Target Amount: " + targetAmount;
    }

    // UpdateActivity method
    public String updateActivity(String activityName, String description, double targetAmount) {
        this.activityName = activityName;
        this.description = description;
        this.targetAmount = targetAmount;

        return "Fundraising activity updated successfully.";
    }

    public int getActivityId() {
        return activityId;
    }

    public String getActivityName() {
        return activityName;
    }

    public String getDescription() {
        return description;
    }

    public double getTargetAmount() {
        return targetAmount;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTargetAmount(double targetAmount) {
        this.targetAmount = targetAmount;
    }
}