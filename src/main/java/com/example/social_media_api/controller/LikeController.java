package com.example.social_media_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.social_media_api.entity.Like;
import com.example.social_media_api.service.LikeService;

@RestController
@RequestMapping("/api/likes")
public class LikeController {

    @Autowired
    private LikeService likeService;

    @PostMapping
    public Like createLike(@RequestBody Like like) {

        return likeService.createLike(like);
    }
}