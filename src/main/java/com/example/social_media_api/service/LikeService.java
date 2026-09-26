package com.example.social_media_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.social_media_api.entity.Like;
import com.example.social_media_api.entity.LikeId;
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

        postRepository.incrementLikeCount(
            like.getId().getPostId()
        );

        likeRepository.flush();

        return likeRepository.findById(savedLike.getId()).orElseThrow();
    }

    @Transactional
    public boolean deleteLike(long postId, long userId) {

        LikeId likeId = new LikeId(postId, userId);

        if (!likeRepository.existsById(likeId)) {
            return false;
        }

        likeRepository.deleteById(likeId);

        postRepository.decrementLikeCount(postId);

        return true;
    }
}