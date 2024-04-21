package com.gmr.securent.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gmr.securent.entity.Landlord;
import com.gmr.securent.exceptions.UserNotFoundException;
import com.gmr.securent.responses.LandlordResponse;
import com.gmr.securent.service.LandlordService;

@RestController
@RequestMapping("/landlords")
public class LandlordController {

    private LandlordService landlordService;

    public LandlordController(LandlordService landlordService) {
        this.landlordService = landlordService;
    }
    
    @GetMapping
    public List<LandlordResponse> getAllLandlordEntities() {
        return landlordService.getAllLandlords().stream().map(u -> new LandlordResponse(u)).toList();
    }

    @PostMapping
    public ResponseEntity<Void> createNewLandlord(@RequestBody Landlord newLandlord) {
        Landlord landlord = landlordService.saveOneLandlord(newLandlord);
        if (landlord != null)
            return new ResponseEntity<>(HttpStatus.CREATED);
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/{landlordId}")
    public LandlordResponse getOneLandlord(@PathVariable Integer landlordId) {
        Landlord landlord = landlordService.getOneLandlordById(landlordId);
        if (landlord == null) {
            throw new UserNotFoundException();
        }
        return new LandlordResponse(landlord);
    }

    @PutMapping("/{landlordId}")
    public ResponseEntity<Void> updateOneLandlord(@PathVariable Integer landlordId, @RequestBody Landlord newLandlord) {
        Landlord landlord = landlordService.updateOneLandlord(landlordId, newLandlord);
        if (landlord != null) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @DeleteMapping("/{landlordId}")
    public void deleteOneLandlord(@PathVariable Integer landlordId) {
        landlordService.deleteById(landlordId);
    }
}
