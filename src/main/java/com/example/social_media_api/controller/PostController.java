package com.example.social_media_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.social_media_api.entity.Post;
import com.example.social_media_api.service.PostService;

@RestController 
@RequestMapping("/api/posts")
public class PostController {
    
    @Autowired
    private PostService postService;

    @PostMapping
    public Post createPost(@RequestBody Post post) {
        return postService.createPost(post);
    }

    @GetMapping
    public List<Post> getPostsByUserId(
            @RequestParam long userId) {

        return postService.getPostsByUserId(userId);
    }

    @DeleteMapping
    public ResponseEntity<String> deletePost(
            @RequestParam long postId) {

        boolean deleted = postService.deletePost(postId);

        if (!deleted) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Post not found");
        }

        return ResponseEntity.ok("Post deleted successfully");
    }
}
