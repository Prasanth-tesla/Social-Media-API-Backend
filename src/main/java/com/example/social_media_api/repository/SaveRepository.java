package com.example.social_media_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.social_media_api.entity.Save;
import com.example.social_media_api.entity.SaveId;

public interface SaveRepository extends JpaRepository<Save, SaveId> {
    
}