package com.example.social_media_api.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "likes")
public class Like {
    
    @EmbeddedId
    private LikeId id;

    @Column(name = "created_at", insertable = false, updatable = false)
    private LocalDate createdAt;

    public Like() {}

    // getters
    public LikeId getId() { return id; }

    public LocalDate getCreatedAt() { return createdAt; }

    // setters
    public void setId(LikeId id) { this.id = id; }
}
