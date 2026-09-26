package com.example.social_media_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.social_media_api.entity.Save;
import com.example.social_media_api.service.SaveService;

@RestController
@RequestMapping("/api/saves")
public class SaveController {

    @Autowired
    private SaveService saveService;

    @PostMapping
    public Save createSave(@RequestBody Save save) {
        return saveService.createSave(save);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteSave(
        @RequestParam long postId,
        @RequestParam long userId) {

        boolean deleted = saveService.deleteSave(postId, userId);

        if (!deleted) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Save not found");
        }

        return ResponseEntity.ok("Post unsaved successfully");
    }
}