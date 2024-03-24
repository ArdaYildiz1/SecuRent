package com.gmr.securent.service.interfaces;

import com.gmr.securent.entity.RentRequest;
import com.gmr.securent.entity.RealEstateAgentOperations;
import com.gmr.securent.entity.Tenant;
import com.gmr.securent.entity.enums.ServiceType;

import java.util.List;


public interface TenantInterface {
    List<Tenant> getAllTenants();
    Tenant saveOneTenant(Tenant newTenant);
    Tenant getOneTenantById(Integer userId);
    Tenant updateOneTenant(Integer userId, Tenant newTenant);
    void deleteById(Integer userId);
    void payDeposit(Integer userId, Double amount);
    List<RentRequest> getAllRentingRequestsForTenant(Integer tenantId);
    void sendRentingRequestToLandlord(Integer tenantId, Integer landlordId, Integer houseId);
    void cancelRentingRequestToLandlord(Integer serviceID);
    List<RealEstateAgentOperations> getAllRealEstateAgentOperationsForTenant(Integer tenantId);
    void sendRealEstateAgentOperationRequest(Integer tenantId,
                                             Integer realEstateAgentId,
                                             Integer houseId,
                                             ServiceType serviceType);
    void cancelRealEstateAgentOperationRequest(Integer serviceID);
    void rateRealEstateAgent(Integer agentId, Double newRating);
//    public void acceptExtension(boolean renewContract);
//
//    public void reportAd();

}
