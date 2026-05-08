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

    // ViewUserAccount methods
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
}