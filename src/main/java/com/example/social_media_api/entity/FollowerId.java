package com.example.social_media_api.entity;

import java.io.Serializable;

import jakarta.persistence.Embeddable;

@Embeddable 
public class FollowerId implements Serializable {
    
    private long followerId;
    private long followingId;

    public FollowerId() {}

    public FollowerId(long followerId, long followingId) {
        this.followerId = followerId;
        this.followingId = followingId;
    }

    // getters
    public long getFollowerId() { return followerId; }

    public long getFollowingId() { return followingId; }

    // setters
    public void setFollowerId(long followerId) { this.followerId = followerId; }

    public void setFollowingId(long followingId) { this.followingId = followingId; }
}
