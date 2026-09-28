package com.example.social_media_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.social_media_api.entity.Share;

public interface ShareRepository extends JpaRepository<Share, Long> {
    
}