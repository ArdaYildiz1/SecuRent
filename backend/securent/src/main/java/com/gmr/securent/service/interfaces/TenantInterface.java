package com.gmr.securent.service.interfaces;

import com.gmr.securent.entity.RealEstateAgentOperations;
import com.gmr.securent.entity.RentRequest;
import com.gmr.securent.entity.Tenant;
import com.gmr.securent.entity.enums.ServiceType;

import java.util.List;


public interface TenantInterface {
    List<Tenant> getAllTenants();
    Tenant saveOneTenant(Tenant newTenant);
    Tenant getOneTenantById(Integer userId);
    Tenant getOneTenantByEmailAndPassword(String emailAddress, String password);
    Tenant updateOneTenant(Integer userId, Tenant newTenant);
    void deleteById(Integer userId);
    void payDeposit(Integer userId, Double amount);
    List<RentRequest> getAllRentingRequestsForTenant(Integer tenantId);
    void sendRentingRequestToLandlord(Integer tenantId, Integer landlordID, Integer houseId);
    void cancelRentingRequestToLandlord(Integer serviceID);
    List<RealEstateAgentOperations> getAllRealEstateAgentOperationsForTenant(Integer tenantId);
    void sendRealEstateAgentOperationRequest(Integer tenantId,
                                             Integer realEstateAgentId,
                                             Integer houseId,
                                             ServiceType serviceType);
    void cancelRealEstateAgentOperationRequest(Integer serviceID);
    void rateRealEstateAgent(Integer agentId, Double newRating);
//    List<House> getHouses(
//            String address,
//            LocalDate adDate,
//            double areaGross,
//            double areaNet,
//            double areaOpenSpace,
//            int numberOfRooms,
//            int buildingAge,
//            int flatNumber,
//            Heating heating,
//            int numberOfBathrooms,
//            boolean balconyIsPresent,
//            boolean furnitureIsPresent,
//            boolean insideASite,
//            String siteName,
//            double currentAmount);
//    public void acceptExtension(boolean renewContract);
//
//    public void reportAd();

}
