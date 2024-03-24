package com.gmr.securent.service;

import com.gmr.securent.entity.RentRequest;
import com.gmr.securent.entity.RentalService;
import com.gmr.securent.entity.Tenant;
import com.gmr.securent.entity.enums.ServiceType;
import com.gmr.securent.repository.RentRequestRepository;
import com.gmr.securent.repository.RentalServiceRepository;
import com.gmr.securent.repository.TenantRepository;
import com.gmr.securent.service.interfaces.TenantInterface;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TenantService implements TenantInterface {

    // Inject necessary dependencies
    TenantRepository tenantRepository;
    RentRequestRepository rentRequestRepository;
    RentalServiceRepository rentalServiceRepository;

    public TenantService(TenantRepository tenantRepository,
                         RentRequestRepository rentRequestRepository,
                         RentalServiceRepository rentalServiceRepository) {
        this.tenantRepository = tenantRepository;
        this.rentRequestRepository = rentRequestRepository;
        this.rentalServiceRepository = rentalServiceRepository;
    }

    @Override
    public List<Tenant> getAllTenants() {
        return tenantRepository.findAll();
    }
    @Override
    public Tenant saveOneTenant(Tenant newTenant) {
        return tenantRepository.save(newTenant);
    }
    @Override
    public Tenant getOneTenantById(Integer userId) {
        return tenantRepository.findById(userId).orElse(null);
    }
    @Override
    public Tenant updateOneTenant(Integer userId, Tenant newTenant) {
        Optional<Tenant> tenant = tenantRepository.findById(userId);
        if(tenant.isPresent()) {
            Tenant foundTenant = tenant.get();
            foundTenant.setFirstName(newTenant.getFirstName());
            foundTenant.setLastName(newTenant.getLastName());
            foundTenant.setPassword(newTenant.getPassword());
            foundTenant.setPhoneNo(newTenant.getPhoneNo());
            foundTenant.setEmailAddress(newTenant.getEmailAddress());
            foundTenant.setTck(newTenant.getTck());
            foundTenant.setDepositPaymentStatus(newTenant.isDepositPaymentStatus());
            return foundTenant;
        }
        else {
            throw new RuntimeException("Tenant not found with ID: " + userId);
        }
    }
    @Override
    public void deleteById(Integer userId) {
        try {
            tenantRepository.deleteById(userId);
        } catch(EmptyResultDataAccessException e) {
            System.out.println("Tenant "+ userId +" doesn't exist");
        }
    }
    @Override
    public void payDeposit(Integer userId, Double amount) {
        Optional<Tenant> tenantOptional = tenantRepository.findById(userId);
        if (tenantOptional.isPresent()) {
            Tenant tenant = tenantOptional.get();
            tenant.setDepositAmount(amount);
            tenant.setDepositPaymentStatus(true);
            tenantRepository.save(tenant);
        } else {
            throw new RuntimeException("Tenant not found with ID: " + userId);
        }
    }
    @Override
    public List<RentRequest> getAllRentingRequestsForTenant(Integer tenantId) {
        return rentRequestRepository.findAllByTenantID(tenantId);
    }
    @Override
    public void sendRentingRequestToLandlord(Integer tenantId, Integer landlordId, Integer houseId) {
        // Find the tenant
        Tenant tenant = tenantRepository
                .findById(tenantId)
                .orElseThrow(() -> new RuntimeException("Tenant not found with ID: " + tenantId));

        // Create a new RentRequest object
        RentRequest rentRequest = new RentRequest();
        rentRequest.setTenantID(tenantId);
        rentRequest.setLandlordID(landlordId);
        rentRequest.setHouseID(houseId);

        // Save the RentRequest object
        rentRequestRepository.save(rentRequest);
    }
    @Override
    public void cancelRentingRequestToLandlord(Integer rentRequestId) {
        rentRequestRepository.deleteById(rentRequestId);
    }
    @Override
    public List<RentalService> getAllRentalServiceRequestsForTenant(Integer tenantId) {
        return rentalServiceRepository.findAllByTenantID(tenantId);
    }
    @Override
    public void sendRentalServiceRequestToRealEstateAgent(Integer tenantId, Integer realEstateAgentId, Integer houseId) {
        // Find the tenant
        Tenant tenant = tenantRepository
                .findById(tenantId)
                .orElseThrow(() -> new RuntimeException("Tenant not found with ID: " + tenantId));

        // Create a new RentalService object
        RentalService rentalService = new RentalService();
        rentalService.setTenantID(tenantId);
        rentalService.setRealEstateAgentID(realEstateAgentId);
        rentalService.setHouseID(houseId);

        // Save the RentalService object
        rentalServiceRepository.save(rentalService);
    }
    @Override
    public void cancelRentalServiceRequestToRealEstateAgent(Integer rentalServiceId) {
        rentalServiceRepository.deleteById(rentalServiceId);
    }
}