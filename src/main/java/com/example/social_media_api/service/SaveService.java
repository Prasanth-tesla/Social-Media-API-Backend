package com.example.social_media_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.social_media_api.entity.Save;
import com.example.social_media_api.entity.SaveId;
import com.example.social_media_api.repository.PostRepository;
import com.example.social_media_api.repository.SaveRepository;

@Service
public class SaveService {

    @Autowired
    private SaveRepository saveRepository;

    @Autowired
    private PostRepository postRepository;

    @Transactional
    public Save createSave(Save save) {

        saveRepository.save(save);

        postRepository.incrementSaveCount(
            save.getId().getPostId()
        );

        return saveRepository.findById(save.getId()).orElseThrow();
    }

    @Transactional
    public boolean deleteSave(long postId, long userId) {

        SaveId saveId = new SaveId(postId, userId);

        if (!saveRepository.existsById(saveId)) {
            return false;
        }

        saveRepository.deleteById(saveId);

        postRepository.decrementSaveCount(postId);

        return true;
    }
}