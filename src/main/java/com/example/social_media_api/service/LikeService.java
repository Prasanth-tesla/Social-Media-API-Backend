package com.example.social_media_api.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.social_media_api.dto.LikeResponse;
import com.example.social_media_api.entity.Like;
import com.example.social_media_api.entity.LikeId;
import com.example.social_media_api.entity.Post;
import com.example.social_media_api.repository.LikeRepository;
import com.example.social_media_api.repository.PostRepository;

import org.springframework.transaction.annotation.Transactional;

@Service
public class LikeService {

    @Autowired
    private LikeRepository likeRepository;

    @Autowired
    private PostRepository postRepository;

    @Transactional
    public Like createLike(Like like) {

        Like savedLike = likeRepository.save(like);

        likeRepository.flush();

        return likeRepository.findById(savedLike.getId()).orElseThrow();
    }

    @Transactional
    public boolean deleteLike(long postId, long userId) {

        Authentication authentication =
                SecurityContextHolder
                        .getContext()
                        .getAuthentication();

        Long authenticatedUserId =
                (Long) authentication.getPrincipal();

        if (!authenticatedUserId.equals(userId)) {
            throw new RuntimeException(
                    "You can only delete your own likes"
            );
        }

        LikeId likeId = new LikeId(postId, userId);

        if (!likeRepository.existsById(likeId)) {
            return false;
        }

        likeRepository.deleteById(likeId);

        return true;
    }

    public List<LikeResponse> getLikesByUserId(long userId) {

        Authentication authentication =
                SecurityContextHolder
                        .getContext()
                        .getAuthentication();

        Long authenticatedUserId =
                (Long) authentication.getPrincipal();

        if (!authenticatedUserId.equals(userId)) {
            throw new RuntimeException(
                    "You can only view your own likes"
            );
        }

        return likeRepository.findLikesByUserId(userId)
                .stream()
                .map(like -> {

                    long postId = like.getId().getPostId();

                    Post post = postRepository.findById(postId)
                            .orElseThrow(() ->
                                    new RuntimeException("Post not found"));

                    return new LikeResponse(
                            like.getCreatedAt(),
                            post
                    );
                })
                .toList();
    }
}