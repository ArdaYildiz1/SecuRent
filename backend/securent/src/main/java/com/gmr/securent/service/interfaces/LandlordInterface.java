package com.gmr.securent.service.interfaces;

import com.gmr.securent.entity.*;

import java.time.LocalDate;
import java.util.List;

public interface LandlordInterface {
    List<Landlord> getAllLandlords();
    Landlord saveOneLandlord(Landlord newLandlord);
    Landlord getOneLandlordById(Integer userId);
    Landlord updateOneLandlord(Integer userId, Landlord newLandlord);
    void deleteById(Integer userId);
    List<House> getAllHousesForLandlord(Integer userId);
    House saveOneHouseForLandlord(Integer userId, House newHouse);
    House updateOneHouseForLandlord(Integer userId, Integer houseId, House newHouse);
    void deleteOneHouseForLandlord(Integer userId, Integer houseId);
    List<RentRequest> getAllRentingRequestsForLandlord(Integer userId);
    void confirmRentingRequest(Integer userId, Integer serviceId);
    void rejectRentingRequest(Integer userId, Integer serviceId);
    RentalContract uploadContract(Integer userId, Integer landlordTck, Integer tenantTck, Double rentAmount, LocalDate startDate, LocalDate endDate);
    void acceptExtension(Integer userId, Integer contractId, Boolean renewContract, Double newRentAmount);
    void rateRealEstateAgent(Integer agentId, Double point);
}
