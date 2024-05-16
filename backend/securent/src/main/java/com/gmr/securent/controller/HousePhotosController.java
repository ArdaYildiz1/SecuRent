package com.gmr.securent.controller;

import com.gmr.securent.entity.HousePhotos;
import com.gmr.securent.repository.HousePhotosRepository;
import com.gmr.securent.service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/house-photos")
@CrossOrigin(origins = "http://securentsys.s3-website.eu-central-1.amazonaws.com")
public class HousePhotosController {
    @Autowired
    private FileUploadService fileUploadService;

    @Autowired
    private HousePhotosRepository housePhotosRepository;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file,
                                             @RequestParam("houseId") Integer houseId) {
        try {
            String filePath = fileUploadService.uploadFile(file);
            HousePhotos housePhotos = new HousePhotos();
            housePhotos.setHouseID(houseId);
            housePhotos.setFilePath(filePath);
            housePhotosRepository.save(housePhotos);
            return ResponseEntity.ok("Photo uploaded successfully");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload photo");
        }
    }
}
