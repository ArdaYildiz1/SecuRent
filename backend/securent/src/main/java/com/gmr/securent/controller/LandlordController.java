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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gmr.securent.entity.House;
import com.gmr.securent.entity.Landlord;
import com.gmr.securent.entity.RentRequest;
import com.gmr.securent.entity.RentalAd;
import com.gmr.securent.entity.RentalContract;
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
        if (landlord != null) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
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

    @GetMapping("/{landlordId}/houses")
    public ResponseEntity<List<House>> getAllHousesForLandlord(@PathVariable Integer landlordId) {
        List<House> houses = landlordService.getAllHousesForLandlord(landlordId);
        return new ResponseEntity<>(houses, HttpStatus.OK);
    }

    @PostMapping("/{landlordId}/houses")
    public ResponseEntity<Void> saveOneHouseForLandlord(@PathVariable Integer landlordId, @RequestBody House newHouse) {
        House house = landlordService.saveOneHouseForLandlord(landlordId, newHouse);
        if (house != null)
            return new ResponseEntity<>(HttpStatus.CREATED);
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PutMapping("/{landlordId}/houses/{houseId}")
    public ResponseEntity<Void> updateOneHouseForLandlord(@PathVariable Integer landlordId, @PathVariable Integer houseId,
                                                          @RequestBody House newHouse) {
        House house = landlordService.updateOneHouseForLandlord(landlordId, houseId, newHouse);
        if (house == null) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{landlordId}/houses/{houseId}")
    public void deleteOneHouseForLandlord(@PathVariable Integer landlordId, @PathVariable Integer houseId) {
        landlordService.deleteOneHouseForLandlord(landlordId, houseId);
    }

    @GetMapping("/{landlordId}/rental-ads")
    public ResponseEntity<List<RentalAd>> getAllRentalAdsForLandlord(@PathVariable Integer landlordId) {
        List<RentalAd> rentalAds = landlordService.getAllRentalAdsForLandlord(landlordId);
        return new ResponseEntity<>(rentalAds, HttpStatus.OK);
    }

    @PostMapping("/{landlordId}/rental-ads")
    public ResponseEntity<Void> createOneRentalAdForLandlord(@PathVariable Integer landlordId, @RequestBody RentalAd newRentalAd) {
        RentalAd rentalAd = landlordService.createOneRentalAd(landlordId,
                                                                newRentalAd.getHouseID(),
                                                                newRentalAd.getRentPrice(),
                                                                newRentalAd.getDescription());
        if (rentalAd != null)
            return new ResponseEntity<>(HttpStatus.CREATED);
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PutMapping("/{landlordId}/rental-ads/{rentalAdId}")
    public ResponseEntity<Void> updateOneHouseForLandlord(@PathVariable Integer landlordId, @PathVariable Integer rentalAdId,
                                                          @RequestBody RentalAd newRentalAd) {
        RentalAd rentalAd = landlordService.updateOneRentalAd(landlordId, rentalAdId, newRentalAd);
        if (rentalAd == null) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{landlordId}/rental-ads/{rentalAdId}")
    public void deleteOneRentalAdForLandlord(@PathVariable Integer landlordId, @PathVariable Integer rentalAdId) {
        landlordService.deleteOneRentalAd(landlordId, rentalAdId);
    }

    @GetMapping("/{landlordId}/renting-requests")
    public ResponseEntity<List<RentRequest>> getAllRentingRequestsForLandlord(@PathVariable Integer landlordId) {
        List<RentRequest> rentingRequests = landlordService.getAllRentingRequestsForLandlord(landlordId);
        return new ResponseEntity<>(rentingRequests, HttpStatus.OK);
    }

    @PutMapping("/{landlordId}/renting-requests/{serviceId}/confirm")
    public void confirmRentingRequest(@PathVariable Integer landlordId, @PathVariable Integer serviceId) {
        landlordService.confirmRentingRequest(landlordId, serviceId);
    }

    @PutMapping("/{landlordId}/renting-requests/{serviceId}/reject")
    public void rejectRentalService(@PathVariable Integer landlordId, @PathVariable Integer serviceId) {
        landlordService.rejectRentingRequest(landlordId, serviceId);
    }

    @PostMapping("/{landlordId}/contracts")
    public ResponseEntity<Void> createOneRentalAdForLandlord(@PathVariable Integer landlordId,
                                                             @RequestBody RentalContract newRentalContract) {
        RentalContract rentalContract = landlordService.uploadContract(landlordId,
                                                                        newRentalContract.getLandlordTCK(),
                                                                        newRentalContract.getTenantTCK(),
                                                                        newRentalContract.getRentAmount(),
                                                                        newRentalContract.getStartDate(),
                                                                        newRentalContract.getEndDate());
        if (rentalContract != null)
            return new ResponseEntity<>(HttpStatus.CREATED);
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PutMapping("/{landlordId}/contracts/{contractId}")
    public void acceptExtension(@PathVariable Integer landlordId, @PathVariable Integer contractId,
                                @RequestParam Boolean renewContract, @RequestParam Double amount) {
        landlordService.acceptExtension(landlordId, contractId, renewContract, amount);
    }

    @PostMapping("/{landlordId}/rate-real-estate-agent/{agentId}")
    public ResponseEntity<Void> rateRealEstateAgent(@PathVariable Integer agentId,
                                                    @RequestParam Double rating) {
        landlordService.rateRealEstateAgent(agentId, rating);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
