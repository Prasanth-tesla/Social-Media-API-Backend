package com.example.social_media_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.social_media_api.entity.Share;
import com.example.social_media_api.repository.PostRepository;
import com.example.social_media_api.repository.ShareRepository;

@Service
public class ShareService {

    @Autowired
    private ShareRepository shareRepository;

    @Autowired
    private PostRepository postRepository;

    @Transactional
    public Share createShare(Share share) {

        shareRepository.save(share);

        postRepository.incrementShareCount(
            share.getPostId()
        );

        return share;
    }
}