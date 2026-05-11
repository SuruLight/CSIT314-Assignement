package com.FRA.login_system.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "useraccounts")
public class UserAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String username;
    private String email;
    
    
    private String permissions; 
    private boolean suspended;

    @ManyToOne
    @JoinColumn(name = "role") // This handles the 'role' column now
    private UserProfile profile;

    // Getters
    public int getId() { return id; }
    public String getUsername() { return username; }
    public String getEmail() { return email; }
    
    public String getRole() { 
        return (profile != null) ? profile.getRole() : null; 
    }
    
    public String getPermissions() { return permissions; }
    public boolean isSuspended() { return suspended; }
    public UserProfile getProfile() { return profile; }

    // Setters
    public void setUsername(String username) { this.username = username; }
    public void setEmail(String email) { this.email = email; }
    
    // Updated Setter: If you need to set by string, you'd usually set the whole profile object instead
    // But for now, we remove the direct setRole(String) to avoid confusion
    
    public void setPermissions(String permissions) { this.permissions = permissions; }
    public void setSuspended(boolean suspended) { this.suspended = suspended; }
    public void setProfile(UserProfile profile) { this.profile = profile; }
}