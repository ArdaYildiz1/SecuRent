package com.gmr.securent.service.interfaces;

import com.gmr.securent.entity.Tenant;

import java.util.List;


public interface TenantInterface {
    List<Tenant> getAllTenants();
    Tenant saveOneTenant(Tenant newTenant);
    Tenant getOneTenantById(Integer userId);
    Tenant updateOneTenant(Integer userId, Tenant newTenant);
    void deleteById(Integer userId);
    
//    public void payDeposit(int amount);
//
//    public void sendRentingRequestToLandlord(RentRequest rentRequest);
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
