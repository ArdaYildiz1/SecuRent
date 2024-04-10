package com.gmr.securent.service.interfaces;

import com.gmr.securent.entity.RealEstateAgent;
import com.gmr.securent.entity.RealEstateAgentOperations;

import java.util.List;


public interface RealEstateAgentInterface {
    List<RealEstateAgent> getAllRealEstateAgents();
    RealEstateAgent saveOneRealEstateAgent(RealEstateAgent newRealEstateAgent);
    RealEstateAgent getOneRealEstateAgentById(Integer userId);
    RealEstateAgent updateOneRealEstateAgent(Integer userId, RealEstateAgent newRealEstateAgent);
    void deleteById(Integer userId);
    List<RealEstateAgentOperations> getAllRentalServiceRequestsForRealEstateAgent(Integer realEstateAgentId);
    void acceptRentalService(Integer rentalServiceID);
    void rejectRentalService(Integer rentalServiceID);

}
