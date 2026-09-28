package com.example.social_media_api.dto;

import java.time.LocalDate;

public class FollowerResponse {
    
    private Long userId;
    private String userName;
    private Long followerCount;
    private Long followingCount;
    private Long postCount;
    private LocalDate createdAt;

    public FollowerResponse(
            Long userId,
            String userName,
            Long followerCount,
            Long followingCount,
            Long postCount,
            LocalDate createdAt) {

        this.userId = userId;
        this.userName = userName;
        this.followerCount = followerCount;
        this.followingCount = followingCount;
        this.postCount = postCount;
        this.createdAt = createdAt;
    }

    public Long getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public Long getFollowerCount() {
        return followerCount;
    }

    public Long getFollowingCount() {
        return followingCount;
    }

    public Long getPostCount() {
        return postCount;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }
}
