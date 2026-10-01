package com.example.social_media_api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.security.core.Authentication;

import com.example.social_media_api.dto.FollowRequest;
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
    public void createFollower(FollowRequest request) {

        Authentication authentication =
                SecurityContextHolder
                        .getContext()
                        .getAuthentication();

        Long authenticatedUserId =
                (Long) authentication.getPrincipal();

        FollowerId followerId =
                new FollowerId(
                        authenticatedUserId,
                        request.getFollowingId()
                );

        Follower follower = new Follower();
        follower.setId(followerId);

        followerRepository.save(follower);
    }
    
    @Transactional
        public boolean deleteFollower(long followingId) {

        Authentication authentication =
                SecurityContextHolder
                        .getContext()
                        .getAuthentication();

        Long authenticatedUserId =
                (Long) authentication.getPrincipal();

        FollowerId followerKey =
                new FollowerId(
                        authenticatedUserId,
                        followingId
                );

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
                        (String) row[1]
                ))
                .toList();
    }

    public List<FollowerResponse> getFollowing(long userId) {

        return followerRepository.findFollowingByUserId(userId)
                .stream()
                .map(row -> new FollowerResponse(
                        ((Number) row[0]).longValue(),
                        (String) row[1]
                ))
                .toList();
    }
}