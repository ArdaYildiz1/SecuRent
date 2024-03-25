package com.gmr.securent.service;

import java.util.List;
import java.util.Optional;

import org.springframework.dao.EmptyResultDataAccessException;

import com.gmr.securent.entity.Landlord;
import com.gmr.securent.repository.LandlordRepository;
import com.gmr.securent.service.interfaces.LandlordInterface;

public class LandlordService implements LandlordInterface {
    LandlordRepository landlordRepository;

    public LandlordService(LandlordRepository landlordRepository) {
        this.landlordRepository = landlordRepository;
    }

    @Override
    public List<Landlord> getAllLandlords() {
        return landlordRepository.findAll();
    }

    @Override
    public Landlord saveOneLandlord(Landlord newLandlord) {
        return landlordRepository.save(newLandlord);
    }

    @Override
    public Landlord getOneLandlordById(Integer userId) {
        return landlordRepository.findById(userId).orElse(null);
    }

    @Override
    public Landlord updateOneLandlord(Integer userId, Landlord newLandlord) {
        Optional<Landlord> landlord = landlordRepository.findById(userId);
        if (landlord.isPresent()) {
            Landlord foundLandlord  = landlord.get();
            foundLandlord.setFirstName(newLandlord.getFirstName());
            foundLandlord.setLastName(newLandlord.getLastName());
            foundLandlord.setPassword(newLandlord.getPassword());
            foundLandlord.setEmailAddress(newLandlord.getEmailAddress());
            foundLandlord.setPhoneNo(newLandlord.getPhoneNo());
            foundLandlord.setTck(newLandlord.getTck());
            return foundLandlord;
        }
        else {
            throw new RuntimeException("Tenant not found with ID: " + userId);
        }
    }

    @Override
    public void deleteById(Integer userId) {
        try {
            landlordRepository.deleteById(userId);
        } catch (EmptyResultDataAccessException e) {
            System.err.println("Landlord " + userId + " doesn't exist.");
        }
    }

    // TODO Add remaining function implementations on March 25th
}
