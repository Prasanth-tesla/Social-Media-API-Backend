package com.example.social_media_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.social_media_api.entity.Like;
import com.example.social_media_api.entity.LikeId;

public interface LikeRepository extends JpaRepository<Like, LikeId> {

}