package com.example.social_media_api.entity;

import java.io.Serializable;

import jakarta.persistence.Embeddable;

@Embeddable 
public class LikeId implements Serializable{
    
    private long postId;
    private long userId;

    public LikeId() {}

    public LikeId(long postId, long userId) {
        this.postId = postId;
        this.userId = userId;
    }

    // getters
    public long getPostId() { return postId; }

    public long getUserId() { return userId; }

    // setters
    public void setPostId(long postId) { this.postId = postId; }

    public void setUserId(long userId) { this.userId = userId; }
}
