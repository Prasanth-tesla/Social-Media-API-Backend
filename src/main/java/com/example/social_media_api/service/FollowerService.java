package com.example.social_media_api.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.social_media_api.dto.FollowerResponse;
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

        return true;
    }

    public List<FollowerResponse> getFollowers(long userId) {

    return followerRepository.findFollowersByUserId(userId)
            .stream()
            .map(row -> new FollowerResponse(
                    ((Number) row[0]).longValue(),
                    (String) row[1],
                    ((Number) row[2]).longValue(),
                    ((Number) row[3]).longValue(),
                    ((Number) row[4]).longValue(),
                    ((LocalDateTime) row[5]).toLocalDate()
            ))
            .toList();
    }

    public List<FollowerResponse> getFollowing(long userId) {

        return followerRepository.findFollowingByUserId(userId)
                .stream()
                .map(row -> new FollowerResponse(
                        ((Number) row[0]).longValue(),
                        (String) row[1],
                        ((Number) row[2]).longValue(),
                        ((Number) row[3]).longValue(),
                        ((Number) row[4]).longValue(),
                        ((LocalDateTime) row[5]).toLocalDate()
                ))
                .toList();
    }
}