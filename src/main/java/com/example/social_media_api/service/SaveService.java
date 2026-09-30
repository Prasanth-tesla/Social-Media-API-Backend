package com.example.social_media_api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.social_media_api.dto.SaveRequest;
import com.example.social_media_api.dto.SaveResponse;
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
    public void createSave(SaveRequest request) {

        Authentication authentication =
                SecurityContextHolder
                        .getContext()
                        .getAuthentication();

        Long authenticatedUserId =
                (Long) authentication.getPrincipal();

        SaveId saveId =
                new SaveId(
                        request.getPostId(),
                        authenticatedUserId
                );

        Save save = new Save();
        save.setId(saveId);

        saveRepository.save(save);
    }

    public List<SaveResponse> getMySaves() {

        Authentication authentication =
                SecurityContextHolder
                        .getContext()
                        .getAuthentication();

        Long authenticatedUserId =
                (Long) authentication.getPrincipal();

        return saveRepository.findSaveResponsesByUserId(
                authenticatedUserId
        );
    }

    @Transactional
    public boolean deleteSave(long postId) {

        Authentication authentication =
                SecurityContextHolder
                        .getContext()
                        .getAuthentication();

        Long authenticatedUserId =
                (Long) authentication.getPrincipal();

        SaveId saveId =
                new SaveId(
                        postId,
                        authenticatedUserId
                );

        if (!saveRepository.existsById(saveId)) {
            return false;
        }

        saveRepository.deleteById(saveId);

        return true;
    }
}