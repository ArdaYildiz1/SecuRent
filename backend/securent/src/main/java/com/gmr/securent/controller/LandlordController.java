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
    public List<Landlord> getAllLandlordEntities() {
        return landlordService.getAllLandlords();
    }

    @PostMapping
    public ResponseEntity<Void> createNewLandlord(@RequestBody Landlord newLandlord) {
        Landlord landlord = landlordService.saveOneLandlord(newLandlord);
        if (landlord != null) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/{landlordID}")
    public Landlord getOneLandlord(@PathVariable Integer landlordID) {
        Landlord landlord = landlordService.getOneLandlordById(landlordID);
        if (landlord == null) {
            throw new UserNotFoundException();
        }
        return landlord;
    }

    @PutMapping("/{landlordID}")
    public ResponseEntity<Void> updateOneLandlord(@PathVariable Integer landlordID, @RequestBody Landlord newLandlord) {
        Landlord landlord = landlordService.updateOneLandlord(landlordID, newLandlord);
        if (landlord != null) {
            System.out.println("LANDLORD TEST:" + landlord.toString());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @DeleteMapping("/{landlordID}")
    public void deleteOneLandlord(@PathVariable Integer landlordID) {
        landlordService.deleteById(landlordID);
    }

    @GetMapping("/{landlordID}/houses")
    public ResponseEntity<List<House>> getAllHousesForLandlord(@PathVariable Integer landlordID) {
        List<House> houses = landlordService.getAllHousesForLandlord(landlordID);
        return new ResponseEntity<>(houses, HttpStatus.OK);
    }

    @PostMapping("/{landlordID}/houses")
    public ResponseEntity<Void> saveOneHouseForLandlord(@PathVariable Integer landlordID, @RequestBody House newHouse) {
        House house = landlordService.saveOneHouseForLandlord(landlordID, newHouse);
        if (house != null)
            return new ResponseEntity<>(HttpStatus.CREATED);
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PutMapping("/{landlordID}/houses/{houseId}")
    public ResponseEntity<Void> updateOneHouseForLandlord(@PathVariable Integer landlordID, @PathVariable Integer houseId,
                                                          @RequestBody House newHouse) {
        House house = landlordService.updateOneHouseForLandlord(landlordID, houseId, newHouse);
        if (house == null) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{landlordID}/houses/{houseId}")
    public void deleteOneHouseForLandlord(@PathVariable Integer landlordID, @PathVariable Integer houseId) {
        landlordService.deleteOneHouseForLandlord(landlordID, houseId);
    }

//    @GetMapping("/{landlordID}/rental-ads")
//    public ResponseEntity<List<RentalAd>> getAllRentalAdsForLandlord(@PathVariable Integer landlordID) {
//        List<RentalAd> rentalAds = landlordService.getAllRentalAdsForLandlord(landlordID);
//        return new ResponseEntity<>(rentalAds, HttpStatus.OK);
//    }
//
//    @PostMapping("/{landlordID}/rental-ads")
//    public ResponseEntity<Void> createOneRentalAdForLandlord(@PathVariable Integer landlordID, @RequestBody RentalAd newRentalAd) {
//        RentalAd rentalAd = landlordService.createOneRentalAd(landlordID,
//                                                                newRentalAd.getHouseID(),
//                                                                newRentalAd.getRentPrice(),
//                                                                newRentalAd.getDescription());
//        if (rentalAd != null)
//            return new ResponseEntity<>(HttpStatus.CREATED);
//        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//    }
//
//    @PutMapping("/{landlordID}/rental-ads/{rentalAdId}")
//    public ResponseEntity<Void> updateOneHouseForLandlord(@PathVariable Integer landlordID, @PathVariable Integer rentalAdId,
//                                                          @RequestBody RentalAd newRentalAd) {
//        RentalAd rentalAd = landlordService.updateOneRentalAd(landlordID, rentalAdId, newRentalAd);
//        if (rentalAd == null) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
//
//    @DeleteMapping("/{landlordID}/rental-ads/{rentalAdId}")
//    public void deleteOneRentalAdForLandlord(@PathVariable Integer landlordID, @PathVariable Integer rentalAdId) {
//        landlordService.deleteOneRentalAd(landlordID, rentalAdId);
//    }

    @GetMapping("/{landlordID}/renting-requests")
    public ResponseEntity<List<RentRequest>> getAllRentingRequestsForLandlord(@PathVariable Integer landlordID) {
        List<RentRequest> rentingRequests = landlordService.getAllRentingRequestsForLandlord(landlordID);
        return new ResponseEntity<>(rentingRequests, HttpStatus.OK);
    }

    @PutMapping("/{landlordID}/renting-requests/{serviceId}/confirm")
    public void confirmRentingRequest(@PathVariable Integer landlordID, @PathVariable Integer serviceId) {
        landlordService.confirmRentingRequest(landlordID, serviceId);
    }

    @PutMapping("/{landlordID}/renting-requests/{serviceId}/reject")
    public void rejectRentalService(@PathVariable Integer landlordID, @PathVariable Integer serviceId) {
        landlordService.rejectRentingRequest(landlordID, serviceId);
    }

    @PostMapping("/{landlordID}/contracts")
    public ResponseEntity<Void> createOneContractForLandlord(@PathVariable Integer landlordID,
                                                             @RequestBody RentalContract newRentalContract) {
        RentalContract rentalContract = landlordService.uploadContract(landlordID,
                                                                        newRentalContract.getLandlordTCK(),
                                                                        newRentalContract.getTenantTCK(),
                                                                        newRentalContract.getRentAmount(),
                                                                        newRentalContract.getStartDate(),
                                                                        newRentalContract.getEndDate());
        if (rentalContract != null)
            return new ResponseEntity<>(HttpStatus.CREATED);
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PutMapping("/{landlordID}/contracts/{contractId}")
    public void acceptExtension(@PathVariable Integer landlordID, @PathVariable Integer contractId,
                                @RequestParam Boolean renewContract, @RequestParam Double amount) {
        landlordService.acceptExtension(landlordID, contractId, renewContract, amount);
    }

    @PostMapping("/{landlordID}/rate-real-estate-agent/{agentId}")
    public ResponseEntity<Void> rateRealEstateAgent(@PathVariable Integer agentId,
                                                    @RequestParam Double rating) {
        landlordService.rateRealEstateAgent(agentId, rating);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
