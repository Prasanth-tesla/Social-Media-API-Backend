package com.example.social_media_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.social_media_api.entity.FollowerId;
import com.example.social_media_api.entity.Follower;

public interface FollowerRepository extends JpaRepository<Follower, FollowerId>{
    
}
