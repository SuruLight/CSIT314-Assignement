package com.FRA.login_system.entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
@Component // 👈 makes Spring manage this class
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String password;
    private String role;
    private String fullName;
    private String email;
    private String phone;
    private boolean suspended;
    private String permissions;

    public User() {}

    // ===== GETTERS =====
    public int getId() {return id;}
    public String getUsername() {return username;}
    public String getPassword() {return password;}
    public String getRole() {return role;}
    public String getFullName() {return fullName;}
    public String getEmail() {return email;}
    public String getPhone() {return phone;}
    public boolean isSuspended() {return suspended;}
    public String getPermissions() {return permissions;}

    // ===== SETTERS =====
    public void setUsername(String username) {this.username = username;}
    public void setPassword(String password) {this.password = password;}
    public void setRole(String role) {this.role = role;}
    public void setFullName(String fullName) {this.fullName = fullName;}
    public void setEmail(String email) {this.email = email;}
    public void setPhone(String phone) {this.phone = phone;}
    public void setPermissions(String permissions) {this.permissions = permissions;}

    // SuspendUserAccount methods
    public void saveStatusDB(boolean suspensionState) {
        this.suspended = suspensionState;
    }

    public String getAccountInfo() {
    return "User ID: " + id +
           ", Username: " + username +
           ", Role: " + role +
           ", Full Name: " + fullName +
           ", Email: " + email +
           ", Phone: " + phone +
           ", Suspended: " + suspended;
    }

    // UpdateUserAccount methods
    public void updateUserAccount(String accountName, String roleType, String permissions) {
        this.username = accountName;
        this.role = roleType;
        this.permissions = permissions;
    }

    public User returnUserAccount() {
        return this;
    }

    // ViewUserAccount  methods
    public String getUser(int userID) {
        if (this.id == userID) {
            return "User ID: " + id +
               ", Username: " + username +
               ", Role: " + role +
               ", Full Name: " + fullName +
               ", Email: " + email +
               ", Phone: " + phone +
               ", Permissions: " + permissions +
               ", Suspended: " + suspended;}
        return "User not found";
    }

    // CreateUserAccount methods
    public boolean createUserAccount(String userName, String role, String permissions, String password, String email) {
        this.username = userName;
        this.role = role;
        this.permissions = permissions;
        this.password = password;
        this.email = email;
        this.suspended = false;

        return true;
    }
    // SearchUserProfile methods
    public boolean findUser(String criteria) {

    return username.toLowerCase().contains(criteria.toLowerCase())
        || fullName.toLowerCase().contains(criteria.toLowerCase())
        || email.toLowerCase().contains(criteria.toLowerCase());
    }

    // SuspendUserProfile methods
    public void suspendProfile() {
        this.suspended = true;
    }

    // UpdateUserProfile methods
    public void updateProfile(String profileName, String roleType, String permissions) {
        this.fullName = profileName;
        this.role = roleType;
        this.permissions = permissions;
    }
    // ViewUserProfile methods
    public String getAllUserProfiles() {
    return "User ID: " + id +
           ", Username: " + username +
           ", Full Name: " + fullName +
           ", Email: " + email +
           ", Phone: " + phone +
           ", Role: " + role +
           ", Permissions: " + permissions;
    }

    // CreateUserProfile methods
    public void createProfile(String profileName, String roleType, String permissions) {
        this.fullName = profileName;
        this.role = roleType;
        this.permissions = permissions;
        this.suspended = false;
    }
}