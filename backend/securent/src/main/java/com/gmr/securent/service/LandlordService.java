package com.gmr.securent.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.dao.EmptyResultDataAccessException;

import com.gmr.securent.entity.House;
import com.gmr.securent.entity.HouseProperties;
import com.gmr.securent.entity.Landlord;
import com.gmr.securent.entity.RentRequest;
import com.gmr.securent.entity.RentalAd;
import com.gmr.securent.repository.HouseRepository;
import com.gmr.securent.repository.LandlordRepository;
import com.gmr.securent.repository.RentRequestRepository;
import com.gmr.securent.repository.RentalAdRepository;
import com.gmr.securent.service.interfaces.LandlordInterface;

public class LandlordService implements LandlordInterface {
    LandlordRepository landlordRepository;
    HouseRepository houseRepository;
    RentalAdRepository rentalAdRepository;
    RentRequestRepository rentRequestRepository;

    public LandlordService(LandlordRepository landlordRepository,
                           HouseRepository houseRepository,
                           RentalAdRepository rentalAdRepository,
                           RentRequestRepository rentRequestRepository) {
        this.landlordRepository = landlordRepository;
        this.houseRepository = houseRepository;
        this.rentalAdRepository = rentalAdRepository;
        this.rentRequestRepository = rentRequestRepository;
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
        return houseRepository.findAllByLandlordID(userId);
    }

    @Override
    public House saveOneHouseForLandlord(Integer userId, HouseProperties newHouseProperties) {
        // Find the landlord
        Landlord landlord = landlordRepository
                                .findById(userId)
                                .orElseThrow(() -> new RuntimeException("Landlord not found with ID: " + userId));

        // Create a new House object
        House house = new House();
        house.setLandlordID(userId);
        house.setHouseProperties(newHouseProperties);

        // Save the House object
        return houseRepository.save(house);
    }

    @Override
    public House updateOneHouseForLandlord(Integer userId, Integer houseId, HouseProperties newHouseProperties) {
        Optional<House> house = houseRepository.findById(houseId);
        if (house.isPresent()) {
            House foundHouse = house.get();
            if (foundHouse.getLandlordID() == userId) {
                foundHouse.setHouseProperties(newHouseProperties);
                return foundHouse;
            }
            else {
                throw new RuntimeException("House with ID " + houseId + " doesn't belong to landlord with ID " + userId);
            }
        }
        else {
            throw new RuntimeException("House not found with ID: " + houseId);
        }
    }

    @Override
    public void deleteOneHouseForLandlord(Integer userId, Integer houseId) {
        Optional<House> house = houseRepository.findById(houseId);
        if (house.isPresent()) {
            House foundHouse = house.get();
            if (foundHouse.getLandlordID() == userId) {
                houseRepository.deleteById(houseId);
            }
            else {
                throw new RuntimeException("House with ID " + houseId + " doesn't belong to landlord with ID " + userId);
            }
        }
        else {
            throw new RuntimeException("House not found with ID: " + houseId);
        }
    }

    @Override
    public List<RentalAd> getAllRentalAdsForLandlord(Integer userId) {
        List<House> houses = getAllHousesForLandlord(userId);
        List<RentalAd> rentalAds = new ArrayList<RentalAd>();
        for (House house : houses) {
            RentalAd rentalAd = rentalAdRepository.findByHouseID(house.getHouseId());
            if (rentalAd != null) {
                rentalAds.add(rentalAd);
            }
        }
        return rentalAds;
    }

    @Override
    public RentalAd createOneRentalAd(Integer userId, Integer houseId, Double rentPrice, String description) {
        // Find the landlord
        Landlord landlord = landlordRepository
                                .findById(userId)
                                .orElseThrow(() -> new RuntimeException("Landlord not found with ID: " + userId));
        
        // Create a new RentalAd object
        RentalAd rentalAd = new RentalAd();
        rentalAd.setHouseID(houseId);
        rentalAd.setRentPrice(rentPrice);
        rentalAd.setDescription(description);

        // Save the Rental Ad object
        return rentalAdRepository.save(rentalAd);
    }

    @Override
    public RentalAd updateOneRentalAd(Integer userId, Integer rentalAdId, RentalAd newRentalAd) {
        Optional<RentalAd> rentalAd = rentalAdRepository.findById(rentalAdId);
        if (rentalAd.isPresent()) {
            RentalAd foundRentalAd = rentalAd.get();
            Integer houseId = foundRentalAd.getHouseID();
            Optional<House> house = houseRepository.findById(houseId);
            House foundHouse = house.get();
            if (foundHouse.getLandlordID() == userId) {
                foundRentalAd.setHouseID(newRentalAd.getHouseID());
                foundRentalAd.setRentPrice(newRentalAd.getRentPrice());
                foundRentalAd.setDescription(newRentalAd.getDescription());
                return foundRentalAd;
            }
            else {
                throw new RuntimeException("Rental ad with ID " + rentalAdId + " doesn't belong to landlord with ID " + userId);
            }
        }
        else {
            throw new RuntimeException("Rental ad not found with ID: " + rentalAdId);
        }
    }

    @Override
    public void deleteOneRentalAd(Integer userId, Integer rentalAdId) {
        Optional<RentalAd> rentalAd = rentalAdRepository.findById(rentalAdId);
        if (rentalAd.isPresent()) {
            RentalAd foundRentalAd = rentalAd.get();
            Integer houseId = foundRentalAd.getHouseID();
            Optional<House> house = houseRepository.findById(houseId);
            House foundHouse = house.get();
            if (foundHouse.getLandlordID() == userId) {
                rentalAdRepository.deleteById(rentalAdId);
            }
            else {
                throw new RuntimeException("Rental ad with ID " + rentalAdId + " doesn't belong to landlord with ID " + userId);
            }
        }
        else {
            throw new RuntimeException("Rental ad not found with ID: " + rentalAdId);
        }
    }

    @Override
    public List<RentRequest> getAllRentingRequestsForLandlord(Integer userId) {
        return rentRequestRepository.findAllByLandlordID(userId);
    }

    @Override
    public void confirmRentingRequest(Integer serviceId) {
        RentRequest rentRequest = rentRequestRepository.findById(serviceId).orElse(null);
        if (rentRequest != null) {
            rentRequest.setServiceAccepted(true);
            rentRequestRepository.save(rentRequest);
        }
        else {
            throw new RuntimeException("No renting requests pending to accept.");
        }
    }

    @Override
    public void rejectRentingRequest(Integer serviceId) {
        RentRequest rentRequest = rentRequestRepository.findById(serviceId).orElse(null);
        if (rentRequest != null) {
            rentRequest.setServiceAccepted(false);
            rentRequestRepository.save(rentRequest);
        }
        else {
            throw new RuntimeException("No renting requests pending to accept.");
        }
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
