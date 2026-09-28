package com.example.social_media_api.dto;

import java.time.LocalDate;

import com.example.social_media_api.entity.Post;

public class LikeResponse {

    private LocalDate createdAt;
    private Post post;

    public LikeResponse(LocalDate createdAt, Post post) {
        this.createdAt = createdAt;
        this.post = post;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public Post getPost() {
        return post;
    }
}