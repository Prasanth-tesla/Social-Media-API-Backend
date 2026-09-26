package com.example.social_media_api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.social_media_api.entity.Post;
import com.example.social_media_api.repository.PostRepository;

@Service 
public class PostService {
    
    @Autowired
    private PostRepository postRepository;

    public Post createPost(Post post) {
        Post savedPost = postRepository.save(post);

        postRepository.flush();

        return postRepository.findById(savedPost.getPostId()).orElseThrow();
    }

    public List<Post> getPostsByUserId(long userId) {
        return postRepository.findByUserId(userId);
    }
}
