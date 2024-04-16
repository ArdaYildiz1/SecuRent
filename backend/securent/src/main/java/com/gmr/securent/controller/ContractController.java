package com.gmr.securent.controller;

import com.gmr.securent.entity.Contract;
import com.gmr.securent.repository.ContractRepository;
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
@RequestMapping("/contracts")
public class ContractController {
    @Autowired
    private FileUploadService fileUploadService;

    @Autowired
    private ContractRepository contractRepository;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            String filePath = fileUploadService.uploadFile(file);
            Contract contract = new Contract();
            contract.setFilePath(filePath);
            // Set other contract properties
            contractRepository.save(contract);
            return ResponseEntity.ok("File uploaded successfully");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload file");
        }
    }
}
