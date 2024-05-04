package com.gmr.securent.service;

import com.gmr.securent.entity.*;
import com.gmr.securent.entity.enums.Heating;
import com.gmr.securent.entity.enums.HouseType;
import com.gmr.securent.repository.*;
import com.gmr.securent.service.interfaces.LandlordInterface;
import org.springframework.cglib.core.Local;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LandlordService implements LandlordInterface {
    LandlordRepository landlordRepository;
    HouseRepository houseRepository;
    RentRequestRepository rentRequestRepository;
    RentalContractRepository rentalContractRepository;
    RealEstateAgentRepository realEstateAgentRepository;
    RentalAdRepository rentalAdRepository;

    public LandlordService(LandlordRepository landlordRepository,
                           HouseRepository houseRepository,
                           RentRequestRepository rentRequestRepository,
                           RentalContractRepository rentalContractRepository,
                           RealEstateAgentRepository realEstateAgentRepository,
                           RentalAdRepository rentalAdRepository) {
        this.landlordRepository = landlordRepository;
        this.houseRepository = houseRepository;
        this.rentRequestRepository = rentRequestRepository;
        this.rentalContractRepository = rentalContractRepository;
        this.realEstateAgentRepository = realEstateAgentRepository;
        this.rentalAdRepository = rentalAdRepository;
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
        System.out.println("LANDLORD INSIDE SERVICE TEST:" + newLandlord.toString());
        Optional<Landlord> landlord = landlordRepository.findById(userId);
        if (landlord.isPresent()) {
            Landlord foundLandlord  = landlord.get();
            foundLandlord.setFirstName(newLandlord.getFirstName());
            foundLandlord.setLastName(newLandlord.getLastName());
            foundLandlord.setPassword(newLandlord.getPassword());
            foundLandlord.setEmailAddress(newLandlord.getEmailAddress());
            foundLandlord.setPhoneNo(newLandlord.getPhoneNo());
            foundLandlord.setTck(newLandlord.getTck());
            landlordRepository.save(foundLandlord);
            return foundLandlord;
        }
        else {
            throw new RuntimeException("Landlord not found with ID: " + userId);
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
        return houseRepository.findAllBylandlordID(userId);
    }

    @Override
    public House saveOneHouseForLandlord(Integer userId, House newHouse) {
        // Find the landlord
        Landlord landlord = landlordRepository
                                .findById(userId)
                                .orElseThrow(() -> new RuntimeException("Landlord not found with ID: " + userId));

        // Set the landlord ID to the house
        newHouse.setLandlordID(userId);

        // Save the House object
        return houseRepository.save(newHouse);
    }

    @Override
    public House updateOneHouseForLandlord(Integer userId, Integer houseId, House newHouse) {
        Optional<House> house = houseRepository.findById(houseId);
        if (house.isPresent()) {
            House foundHouse = house.get();
            if (foundHouse.getLandlordID() == userId) {
                foundHouse.setTenantId(newHouse.getTenantId());
                foundHouse.setAddress(newHouse.getAddress());
                foundHouse.setAdDate(newHouse.getAdDate());
                foundHouse.setAreaGross(newHouse.getAreaGross());
                foundHouse.setAreaNet(newHouse.getAreaNet());
                foundHouse.setAreaOpenSpace(newHouse.getAreaOpenSpace());
                foundHouse.setNumberOfRooms(newHouse.getNumberOfRooms());
                foundHouse.setBuildingAge(newHouse.getBuildingAge());
                foundHouse.setFlatNumber(newHouse.getFlatNumber());
                foundHouse.setHeating(newHouse.getHeating());
                foundHouse.setNumberOfBathrooms(newHouse.getNumberOfBathrooms());
                foundHouse.setBalconyIsPresent(newHouse.isBalconyIsPresent());
                foundHouse.setFurnitureIsPresent(newHouse.isFurnitureIsPresent());
                foundHouse.setInsideASite(newHouse.isInsideASite());
                foundHouse.setSiteName(newHouse.getSiteName());
                foundHouse.setRentPrice(newHouse.getRentPrice());
                foundHouse.setAdTitle(newHouse.getAdTitle());
                foundHouse.setLandlordName(newHouse.getLandlordName());
                foundHouse.setLandlordPhoneNumber(newHouse.getLandlordPhoneNumber());
                foundHouse.setAdDetails(newHouse.getAdDetails());
                houseRepository.save(foundHouse);
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
    public List<RentRequest> getAllRentingRequestsForLandlord(Integer userId) {
        return rentRequestRepository.findAllBylandlordID(userId);
    }

    @Override
    public void confirmRentingRequest(Integer userId, Integer serviceId) {
        RentRequest rentRequest = rentRequestRepository.findById(serviceId).orElse(null);
        if (rentRequest != null) {
            if (userId != rentRequest.getLandlordID()) {
                throw new RuntimeException("Renting request with ID " + serviceId + " doesn't belong to landlord with ID " + userId);
            }
            else {
                rentRequest.setServiceAccepted(true);
                rentRequestRepository.save(rentRequest);
            }
        }
        else {
            throw new RuntimeException("No renting requests pending to accept.");
        }
    }

    @Override
    public void rejectRentingRequest(Integer userId, Integer serviceId) {
        RentRequest rentRequest = rentRequestRepository.findById(serviceId).orElse(null);
        if (rentRequest != null) {
            if (userId != rentRequest.getLandlordID()) {
                throw new RuntimeException("Renting request with ID " + serviceId + " doesn't belong to landlord with ID " + userId);
            }
            else {
                rentRequest.setServiceAccepted(false);
                rentRequestRepository.save(rentRequest);
            }
        }
        else {
            throw new RuntimeException("No renting requests pending to accept.");
        }
    }

    @Override
    public RentalContract uploadContract(Integer userId, Integer landlordTck, Integer tenantTck,
                                         Double rentAmount, LocalDate startDate, LocalDate endDate) {
        // Find the landlord
        Landlord landlord = landlordRepository
                                .findById(userId)
                                .orElseThrow(() -> new RuntimeException("Landlord not found with ID: " + userId));

        // Check if the landlord is the correct one for this rental contract upload
        if (landlord.getTck() == landlordTck) {
            // Create a new Rental Contract object
            RentalContract rentalContract = new RentalContract();
            rentalContract.setLandlordTCK(landlordTck);
            rentalContract.setTenantTCK(tenantTck);
            rentalContract.setRentAmount(rentAmount);
            rentalContract.setStartDate(startDate);
            rentalContract.setEndDate(endDate);
            return rentalContractRepository.save(rentalContract);
        }
        else {
            throw new RuntimeException("Landlord with ID " + userId + "is trying to upload a rental contract for someone else.");
        }
    }

    @Override
    public void acceptExtension(Integer userId, Integer contractId, Boolean renewContract, Double newRentAmount) {
        // Find the landlord
        Landlord landlord = landlordRepository
                                .findById(userId)
                                .orElseThrow(() -> new RuntimeException("Landlord not found with ID: " + userId));

        // Find the rental contract
        RentalContract rentalContract = rentalContractRepository
                                .findById(contractId)
                                .orElseThrow(() -> new RuntimeException("Rental contract not found with ID: " + contractId));

        // Check if the landlord is the correct one for this rental contract
        if (landlord.getTck() == rentalContract.getLandlordTCK()) {
            // Check if the contract will be renewed
            if (renewContract) {
                LocalDate newEndDate = rentalContract.getEndDate().plusYears(5);
                rentalContract.setEndDate(newEndDate);
                rentalContract.setRentAmount(newRentAmount);
                rentalContractRepository.save(rentalContract);
            }
            else {
                // Just added for testing purposes
                System.out.println("Renewal of rental contract with ID " + contractId + " is rejected.");
            }
        }
        else {
            throw new RuntimeException("Rental contract with ID " + contractId + " doesn't belong to landlord with ID " + userId);
        }
    }

    @Override
    public void rateRealEstateAgent(Integer agentId, Double point) {
        // Find the real estate agent
        RealEstateAgent agent = realEstateAgentRepository.findById(agentId)
                .orElseThrow(() -> new RuntimeException("Real Estate Agent not found with ID: " + agentId));

        // Update the rating
        agent.setRating((agent.getRatingCount() * agent.getRating() + point) / (agent.getRatingCount() + 1));
        agent.setRatingCount(agent.getRatingCount() + 1);
        // Save the updated real estate agent
        realEstateAgentRepository.save(agent);
    }

    public RentalAd publishAd(RentalAd rentalAd) {
        return rentalAdRepository.save(rentalAd);
    }
}
