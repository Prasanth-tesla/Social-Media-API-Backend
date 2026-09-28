package com.example.social_media_api.dto;

public class AuthResponse {

    private long userId;
    private String userName;
    private String email;

    public AuthResponse(long userId, String userName, String email) {
        this.userId = userId;
        this.userName = userName;
        this.email = email;
    }

    public long getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }
}