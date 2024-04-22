package com.gmr.securent.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.dao.EmptyResultDataAccessException;

import com.gmr.securent.entity.House;
import com.gmr.securent.entity.Landlord;
import com.gmr.securent.entity.RealEstateAgent;
import com.gmr.securent.entity.RentRequest;
import com.gmr.securent.entity.RentalAd;
import com.gmr.securent.entity.RentalContract;
import com.gmr.securent.repository.HouseRepository;
import com.gmr.securent.repository.LandlordRepository;
import com.gmr.securent.repository.RealEstateAgentRepository;
import com.gmr.securent.repository.RentRequestRepository;
import com.gmr.securent.repository.RentalAdRepository;
import com.gmr.securent.repository.RentalContractRepository;
import com.gmr.securent.service.interfaces.LandlordInterface;

public class LandlordService implements LandlordInterface {
    LandlordRepository landlordRepository;
    HouseRepository houseRepository;
    RentalAdRepository rentalAdRepository;
    RentRequestRepository rentRequestRepository;
    RentalContractRepository rentalContractRepository;
    RealEstateAgentRepository realEstateAgentRepository;

    public LandlordService(LandlordRepository landlordRepository,
                           HouseRepository houseRepository,
                           RentalAdRepository rentalAdRepository,
                           RentRequestRepository rentRequestRepository,
                           RentalContractRepository rentalContractRepository,
                           RealEstateAgentRepository realEstateAgentRepository) {
        this.landlordRepository = landlordRepository;
        this.houseRepository = houseRepository;
        this.rentalAdRepository = rentalAdRepository;
        this.rentRequestRepository = rentRequestRepository;
        this.rentalContractRepository = rentalContractRepository;
        this.realEstateAgentRepository = realEstateAgentRepository;
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
    public House saveOneHouseForLandlord(Integer userId, House newHouse) {
        // Find the landlord
        Landlord landlord = landlordRepository
                                .findById(userId)
                                .orElseThrow(() -> new RuntimeException("Landlord not found with ID: " + userId));

        // Set the landlord ID to the house
        newHouse.setLandlordId(userId);

        // Save the House object
        return houseRepository.save(newHouse);
    }

    @Override
    public House updateOneHouseForLandlord(Integer userId, Integer houseId, House newHouse) {
        Optional<House> house = houseRepository.findById(houseId);
        if (house.isPresent()) {
            House foundHouse = house.get();
            if (foundHouse.getLandlordId() == userId) {
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
                foundHouse.setCurrentAmount(newHouse.getCurrentAmount());
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
            if (foundHouse.getLandlordId() == userId) {
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
            if (foundHouse.getLandlordId() == userId) {
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
            if (foundHouse.getLandlordId() == userId) {
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
        agent.setRating(agent.getRatingCount() * agent.getRating() + point);

        // Save the updated real estate agent
        realEstateAgentRepository.save(agent);
    }
}
