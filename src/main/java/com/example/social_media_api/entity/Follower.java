package com.example.social_media_api.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "followers")
public class Follower {

    @EmbeddedId
    private FollowerId id;

    @Column(name = "created_at", insertable = false, updatable = false)
    private LocalDate createdAt;

    public Follower() {
    }

    // Getters
    public FollowerId getId() {
        return id;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    // Setters
    public void setId(FollowerId id) {
        this.id = id;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }
}