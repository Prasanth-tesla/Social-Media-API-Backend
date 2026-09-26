package com.example.social_media_api.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity 
@Table(name = "posts")
public class Post {
    
    @Id
    private long postId;

    private long userId;

    private String content;

    @Column(name = "like_count", insertable = false, updatable = false)
    private Integer likeCount;

    @Column(name = "share_count", insertable = false, updatable = false)
    private Integer shareCount;

    @Column(name = "save_count", insertable = false, updatable = false)
    private Integer saveCount;

    @Column(name = "created_at", insertable = false, updatable = false)
    private LocalDate createdAt;

    // getters
    public long getPostId() { return postId; }

    public long getUserId() { return userId; }

    public String getContent() { return content; }

    public Integer getLikeCount() { return likeCount; }

    public Integer getShareCount() { return shareCount; }

    public Integer getSaveCount() { return saveCount; }

    public LocalDate getCreatedAt() { return createdAt; }

    // setters

    public void setPostId(long postId) { this.postId = postId; }

    public void setUserId(long userId) { this.userId = userId; }

    public void setContent(String content) { this.content = content; }
}
