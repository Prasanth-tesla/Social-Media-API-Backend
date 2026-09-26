package com.example.social_media_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.social_media_api.entity.Follower;
import com.example.social_media_api.service.FollowerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/followers")
public class FollowerController {
    
    @Autowired
    private FollowerService followerService;

    @PostMapping
    public Follower creatFollowers(@RequestBody Follower follower) {
        return followerService.createFollower(follower);
    }
    
}
