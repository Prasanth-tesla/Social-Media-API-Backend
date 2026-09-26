package com.example.social_media_api.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "saves")
public class Save {

    @EmbeddedId
    private SaveId id;

    @Column(name = "created_at", insertable = false, updatable = false)
    private LocalDate createdAt;

    public Save() {
    }

    // getters
    public SaveId getId() { return id; }

    public LocalDate getCreatedAt() { return createdAt; }

    // setters
    public void setId(SaveId id) { this.id = id; }
}