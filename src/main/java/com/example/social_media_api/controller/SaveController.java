package com.example.social_media_api.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.social_media_api.dto.ApiResponse;
import com.example.social_media_api.dto.SaveRequest;
import com.example.social_media_api.dto.SaveResponse;
import com.example.social_media_api.entity.Save;
import com.example.social_media_api.service.SaveService;

@RestController
@RequestMapping("/api/saves")
public class SaveController {

    @Autowired
    private SaveService saveService;

    @PostMapping
    public ResponseEntity<ApiResponse<Void>> createSave(
            @RequestBody SaveRequest request) {

        saveService.createSave(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(
                    ApiResponse.message(
                        HttpStatus.CREATED,
                        "Post saved successfully"
                    )
                );
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<SaveResponse>>> getMySaves() {

        List<SaveResponse> saves =
                saveService.getMySaves();

        return ResponseEntity.ok(
                ApiResponse.success(
                        HttpStatus.OK,
                        saves
                )
        );
    }

    @DeleteMapping
    public ResponseEntity<ApiResponse<Void>> deleteSave(
            @RequestParam long postId) {

        boolean deleted =
                saveService.deleteSave(postId);
                
        if (!deleted) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(
                        ApiResponse.message(
                            HttpStatus.NOT_FOUND,
                            "Save not found"
                        )
                    );
        }

        return ResponseEntity.ok(
                ApiResponse.message(
                    HttpStatus.OK,
                    "Post unsaved successfully"
                )
        );
    }
}