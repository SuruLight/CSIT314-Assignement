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

    private String category;
    private String status;

    public Activity() {}

    public int getActivityId() {return activityId;}
    public String getActivityName() {return activityName;}
    public String getDescription() {return description;}
    public double getTargetAmount() {return targetAmount;}
    public String getCategory() {return category;}
    public String getStatus() {return status;}

    public void setActivityName(String activityName) {this.activityName = activityName;}
    public void setDescription(String description) {this.description = description;}
    public void setTargetAmount(double targetAmount) {this.targetAmount = targetAmount;}
    public void setCategory(String category) {this.category = category;}
    public void setStatus(String status) {this.status = status;}

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

    // DeleteActivity method
    public String deleteActivity(String activityID) {
        return "Fundraising activity deleted successfully.";
    }

    // SearchActivity method
    public String searchActivity(String activityName, String category, String status) {
        return "Searching activity by name: " + activityName +
            ", category: " + category +
            ", status: " + status;
    }
}