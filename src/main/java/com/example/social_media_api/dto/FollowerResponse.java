package com.example.social_media_api.dto;

public class FollowerResponse {

    private Long userId;
    private String userName;

    public FollowerResponse(
            Long userId,
            String userName) {

        this.userId = userId;
        this.userName = userName;
    }

    public Long getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }
}