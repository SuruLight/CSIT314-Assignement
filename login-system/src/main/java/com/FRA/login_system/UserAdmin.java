package com.FRA.login_system;

public class UserAdmin {

    private String username;
    private String password;

    public UserAdmin(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean verifyCredentials() {
        // Hardcoded for now (replace with DB later)
        return "admin".equals(username) && "1234".equals(password);
    }
}