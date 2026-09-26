package com.example.social_media_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.social_media_api.entity.Follower;
import com.example.social_media_api.repository.FollowerRepository;

@Service 
public class FollowerService {
    @Autowired
    private FollowerRepository followerRepository;

    public Follower createFollower(Follower follower) {
        return followerRepository.save(follower);
    }
}
