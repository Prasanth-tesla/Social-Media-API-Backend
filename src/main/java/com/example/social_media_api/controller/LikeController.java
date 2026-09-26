package com.example.social_media_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @DeleteMapping
    public ResponseEntity<String> deleteLike(
            @RequestParam long postId,
            @RequestParam long userId) {

        boolean deleted = likeService.deleteLike(postId, userId);

        if (!deleted) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Like not found");
        }

        return ResponseEntity.ok("Like removed successfully");
    }
}