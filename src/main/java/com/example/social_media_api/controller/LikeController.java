package com.example.social_media_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.social_media_api.dto.ApiResponse;
import com.example.social_media_api.dto.LikeRequest;
import com.example.social_media_api.dto.LikeResponse;
import com.example.social_media_api.entity.Like;
import com.example.social_media_api.service.LikeService;

@RestController
@RequestMapping("/api/likes")
public class LikeController {

    @Autowired
    private LikeService likeService;

    @PostMapping
    public ResponseEntity<ApiResponse<Void>> createLike(
            @RequestBody LikeRequest request) {

        likeService.createLike(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(
                    ApiResponse.message(
                        HttpStatus.CREATED,
                        "Like added successfully"
                    )
                );
    }

    @DeleteMapping
    public ResponseEntity<ApiResponse<Void>> deleteLike(
            @RequestParam long postId) {

        boolean deleted =
                likeService.deleteLike(postId);

        if (!deleted) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(
                        ApiResponse.message(
                            HttpStatus.NOT_FOUND,
                            "Like not found"
                        )
                    );
        }

        return ResponseEntity.ok(
                ApiResponse.message(
                    HttpStatus.OK,
                    "Like removed successfully"
                )
        );
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<LikeResponse>>> getMyLikes() {

        List<LikeResponse> likes =
                likeService.getMyLikes();

        return ResponseEntity.ok(
                ApiResponse.success(HttpStatus.OK, likes)
        );
    }
}