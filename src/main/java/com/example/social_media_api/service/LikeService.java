package com.example.social_media_api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.social_media_api.dto.LikeRequest;
import com.example.social_media_api.dto.LikeResponse;
import com.example.social_media_api.entity.Like;
import com.example.social_media_api.entity.LikeId;
import com.example.social_media_api.entity.Post;
import com.example.social_media_api.repository.LikeRepository;
import com.example.social_media_api.repository.PostRepository;

@Service
public class LikeService {

    @Autowired
    private LikeRepository likeRepository;
    
    @Autowired
    private PostRepository postRepository;

    @Transactional
    public void createLike(LikeRequest request) {

        Authentication authentication =
                SecurityContextHolder
                        .getContext()
                        .getAuthentication();

        Long authenticatedUserId =
                (Long) authentication.getPrincipal();

        LikeId likeId =
                new LikeId(
                        request.getPostId(),
                        authenticatedUserId
                );

        Like like = new Like();
        like.setId(likeId);

        likeRepository.save(like);
    }

    @Transactional
    public boolean deleteLike(long postId) {

        Authentication authentication =
                SecurityContextHolder
                        .getContext()
                        .getAuthentication();

        Long authenticatedUserId =
                (Long) authentication.getPrincipal();

        LikeId likeId =
                new LikeId(
                        postId,
                        authenticatedUserId
                );

        if (!likeRepository.existsById(likeId)) {
            return false;
        }

        likeRepository.deleteById(likeId);

        return true;
    }

    public List<LikeResponse> getMyLikes() {

        Authentication authentication =
                SecurityContextHolder
                        .getContext()
                        .getAuthentication();

        Long authenticatedUserId =
                (Long) authentication.getPrincipal();

        List<Like> likes =
                likeRepository.findLikesByUserId(
                        authenticatedUserId
                );

        return likes.stream()
                .map(like -> {

                        Post post =
                                postRepository
                                        .findById(
                                        like.getId().getPostId()
                                        )
                                        .orElseThrow();

                        return new LikeResponse(
                                like.getCreatedAt(),
                                post
                        );
                })
                .toList();
        }
}