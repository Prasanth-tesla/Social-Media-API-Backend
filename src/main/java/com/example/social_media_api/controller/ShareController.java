package com.example.social_media_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.social_media_api.entity.Share;
import com.example.social_media_api.service.ShareService;

@RestController
@RequestMapping("/api/shares")
public class ShareController {

    @Autowired
    private ShareService shareService;

    @PostMapping
    public Share createShare(@RequestBody Share share) {
        return shareService.createShare(share);
    }
}