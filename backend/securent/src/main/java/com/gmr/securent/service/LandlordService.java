package com.gmr.securent.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.dao.EmptyResultDataAccessException;

import com.gmr.securent.entity.House;
import com.gmr.securent.entity.Landlord;
import com.gmr.securent.entity.RentRequest;
import com.gmr.securent.entity.RentalAd;
import com.gmr.securent.repository.LandlordRepository;
import com.gmr.securent.repository.RentRequestRepository;
import com.gmr.securent.service.interfaces.LandlordInterface;

public class LandlordService implements LandlordInterface {
    LandlordRepository landlordRepository;
    RentRequestRepository rentRequestRepository;

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

    @Override
    public List<House> getAllHousesForLandlord(Integer userId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public House saveOneHouseForLandlord(Integer userId, House newHouse) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public House updateOneHouseForLandlord(Integer userId, Integer houseId, House newHouse) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void deleteOneHouseForLandlord(Integer userId, Integer houseId) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public List<RentalAd> getAllRentalAdsForLandlord(Integer userId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public RentalAd createOneRentalAd(Integer userId, Integer houseId, Double rentPrice) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public RentalAd updateOneRentalAd(Integer userId, Integer rentalAdId, RentalAd newRentalAd) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void deleteOneRentalAd(Integer userId, Integer rentalAdId) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public List<RentRequest> getAllRentingRequestsForLandlord(Integer userId) {
        return rentRequestRepository.findAllByLandlordID(userId);
    }

    @Override
    public void confirmRentingRequest(Integer serviceId) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void rejectRentingRequest(Integer serviceId) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void uploadContract(Integer landlordTck, Integer tenantTck, Double rentAmount, LocalDate startDate,
            LocalDate endDate) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void acceptExtension(Integer contractId, Boolean renewContract) {
        // TODO Auto-generated method stub

    }

    @Override
    public void rateRealEstateAgent(Integer agentId, Double point) {
        // TODO Auto-generated method stub
        
    }
}
