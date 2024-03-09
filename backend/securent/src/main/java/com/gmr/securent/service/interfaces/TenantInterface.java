package com.gmr.securent.service.interfaces;

import com.gmr.securent.entity.RentRequest;
 

public interface TenantInterface {
    
    public void payDeposit(int amount);

    public void sendRentingRequestToLandlord(RentRequest rentRequest);

    public void cancelRentingRequestToLandlord(RentRequest rentRequest);

    public void requestRentalService() ;

    public void requestRentPriceToBeRecalculated();

    public void acceptExtension(boolean renewContract);

    public void reportAd();

    public void rateRealEstateAgent(int agentId);
}
