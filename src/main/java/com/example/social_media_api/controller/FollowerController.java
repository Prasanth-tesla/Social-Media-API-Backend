package com.example.social_media_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.social_media_api.dto.ApiResponse;
import com.example.social_media_api.dto.FollowRequest;
import com.example.social_media_api.dto.FollowerResponse;
import com.example.social_media_api.service.FollowerService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/follows")
public class FollowerController {
    
    @Autowired
    private FollowerService followerService;

    @PostMapping
    public ResponseEntity<ApiResponse<Void>> createFollower(
        @RequestBody FollowRequest request) {

        followerService.createFollower(request);

        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(
                ApiResponse.message(
                    HttpStatus.CREATED,
                    "Followed successfully"
                )
            );
    }
    
    @DeleteMapping
        public ResponseEntity<ApiResponse<Void>> deleteFollower(
                @RequestParam long followingId) {

        boolean deleted =
                followerService.deleteFollower(followingId);

        if (!deleted) {
                return ResponseEntity
                        .status(HttpStatus.NOT_FOUND)
                        .body(
                        ApiResponse.message(
                                HttpStatus.NOT_FOUND,
                                "Follow relationship not found"
                        )
                        );
        }

        return ResponseEntity.ok(
                ApiResponse.message(
                        HttpStatus.OK,
                        "Unfollowed successfully"
                )
        );
        }

    @GetMapping("/followers")
    public ResponseEntity<ApiResponse<List<FollowerResponse>>> getFollowers(
            @RequestParam long userId) {

        List<FollowerResponse> followers =
                followerService.getFollowers(userId);

        return ResponseEntity.ok(
                ApiResponse.success(
                        HttpStatus.OK,
                        followers
                )
        );
    }

    @GetMapping("/following")
    public ResponseEntity<ApiResponse<List<FollowerResponse>>> getFollowing(
            @RequestParam long userId) {

        List<FollowerResponse> following =
                followerService.getFollowing(userId);

        return ResponseEntity.ok(
                ApiResponse.success(
                        HttpStatus.OK,
                        following
                )
        );
    }
}
