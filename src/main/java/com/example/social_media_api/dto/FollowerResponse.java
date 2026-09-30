package com.example.social_media_api.dto;

import java.time.LocalDate;

public class FollowerResponse {

    private LocalDate createdAt;
    private UserSummary user;

    public FollowerResponse(
            LocalDate createdAt,
            UserSummary user) {

        this.createdAt = createdAt;
        this.user = user;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public UserSummary getUser() {
        return user;
    }
}