package com.gmr.securent.service.interfaces;

import com.gmr.securent.entity.RentRequest;
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
    void sendRentingRequestToLandlord(Integer tenantId,
                                      Integer landlordId,
                                      Integer houseId,
                                      ServiceType serviceType);
//
//    public void cancelRentingRequestToLandlord(RentRequest rentRequest);
//
//    public void requestRentalService() ;
//
//    public void requestRentPriceToBeRecalculated();
//
//    public void acceptExtension(boolean renewContract);
//
//    public void reportAd();
//
//    public void rateRealEstateAgent(int agentId);
}
