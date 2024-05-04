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
    List<RealEstateAgentOperations> getNewRentalServiceRequestsForRealEstateAgent(Integer realEstateAgentId);
    List<RealEstateAgentOperations> getCurrentRentalServiceRequestsForRealEstateAgent(Integer realEstateAgentId);
    List<RealEstateAgentOperations> getOldRentalServiceRequestsForRealEstateAgent(Integer realEstateAgentId);
    List<RealEstateAgentOperations> getNewEvaluationRequestsForRealEstateAgent(Integer realEstateAgentId);
    List<RealEstateAgentOperations> getCurrentEvaluationRequestsForRealEstateAgent(Integer realEstateAgentId);
    List<RealEstateAgentOperations> getOldEvaluationRequestsForRealEstateAgent(Integer realEstateAgentId);
    void acceptRentalService(Integer rentalServiceID);
    void rejectRentalService(Integer rentalServiceID);

}
