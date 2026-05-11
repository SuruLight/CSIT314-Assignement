package com.FRA.login_system.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity
@Table(name = "userprofiles")
public class UserProfile {
    @Id
    private String role; // The short ID like 'FR' or 'USER_ADMIN'

    private String permissions; // Default permissions for this role
    private String description;
    private boolean suspended;

    @Column(name = "profile_name")
    private String profileName; // The full name like 'Fund Raiser'

    // Getters
    public String getRole() { return role; }
    public String getProfileName() { return profileName; }
    public String getPermissions() { return permissions; }
    public String getDescription() { return description; }
    public boolean isSuspended() { return suspended; }

    // Setters
    public void setRole(String role) { this.role = role; }
    public void setProfileName(String profileName) { this.profileName = profileName; }
    public void setPermissions(String permissions) { this.permissions = permissions; }
    public void setDescription(String description) { this.description = description; }
    public void setSuspended(boolean suspended) { this.suspended = suspended; }
}