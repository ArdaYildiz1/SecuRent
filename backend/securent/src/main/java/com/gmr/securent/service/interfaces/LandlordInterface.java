package com.gmr.securent.service.interfaces;

import java.time.LocalDate;
import java.util.List;

import com.gmr.securent.entity.House;
import com.gmr.securent.entity.HouseProperties;
import com.gmr.securent.entity.Landlord;
import com.gmr.securent.entity.RentRequest;
import com.gmr.securent.entity.RentalAd;
import com.gmr.securent.entity.RentalContract;

public interface LandlordInterface {
    List<Landlord> getAllLandlords();
    Landlord saveOneLandlord(Landlord newLandlord);
    Landlord getOneLandlordById(Integer userId);
    Landlord updateOneLandlord(Integer userId, Landlord newLandlord);
    void deleteById(Integer userId);
    List<House> getAllHousesForLandlord(Integer userId);
    House saveOneHouseForLandlord(Integer userId, HouseProperties newHouseProperties);
    House updateOneHouseForLandlord(Integer userId, Integer houseId, HouseProperties newHouseProperties);
    void deleteOneHouseForLandlord(Integer userId, Integer houseId);
    List<RentalAd> getAllRentalAdsForLandlord(Integer userId);
    RentalAd createOneRentalAd(Integer userId, Integer houseId, Double rentPrice, String description);
    RentalAd updateOneRentalAd(Integer userId, Integer rentalAdId, RentalAd newRentalAd);
    void deleteOneRentalAd(Integer userId, Integer rentalAdId);
    List<RentRequest> getAllRentingRequestsForLandlord(Integer userId);
    void confirmRentingRequest(Integer serviceId);
    void rejectRentingRequest(Integer serviceId);
    RentalContract uploadContract(Integer userId, Integer landlordTck, Integer tenantTck, Double rentAmount, LocalDate startDate, LocalDate endDate);
    void acceptExtension(Integer userId, Integer contractId, Boolean renewContract, Double newRentAmount);
    void rateRealEstateAgent(Integer agentId, Double point); // TODO: Check data type of points
}
