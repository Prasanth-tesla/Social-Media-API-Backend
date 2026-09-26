package com.example.social_media_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.social_media_api.entity.Follower;
import com.example.social_media_api.entity.FollowerId;
import com.example.social_media_api.repository.FollowerRepository;
import com.example.social_media_api.repository.UserRepository;

import org.springframework.transaction.annotation.Transactional;

@Service 
public class FollowerService {
    @Autowired
    private FollowerRepository followerRepository;

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public Follower createFollower(Follower follower) {

        Follower savedFollower = followerRepository.save(follower);

        userRepository.incrementFollowingCount(
            follower.getId().getFollowerId()
        );

        userRepository.incrementFollowerCount(
            follower.getId().getFollowingId()
        );

        return savedFollower;
    }
    
    @Transactional
    public boolean deleteFollower(long followerId, long followingId) {

        FollowerId followerKey =
                new FollowerId(followerId, followingId);

        if (!followerRepository.existsById(followerKey)) {
            return false;
        }

        followerRepository.deleteById(followerKey);

        userRepository.decrementFollowingCount(followerId);

        userRepository.decrementFollowerCount(followingId);

        return true;
    }
}
