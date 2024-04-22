package com.gmr.securent.controller;

import com.gmr.securent.entity.ProfilePhotos;
import com.gmr.securent.repository.ProfilePhotosRepository;
import com.gmr.securent.service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/profile-photos")
public class ProfilePhotosController {
    @Autowired
    private FileUploadService fileUploadService;

    @Autowired
    private ProfilePhotosRepository profilePhotosRepository;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file,
                                             @RequestParam("userId") Integer userId) {
        try {
            String filePath = fileUploadService.uploadFile(file);
            ProfilePhotos profilePhotos = new ProfilePhotos();
            profilePhotos.setUserId(userId);
            profilePhotos.setFilePath(filePath);
            profilePhotosRepository.save(profilePhotos);
            return ResponseEntity.ok("Profile photo uploaded successfully");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload profile photo");
        }
    }
}
