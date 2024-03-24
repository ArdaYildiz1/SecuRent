package com.gmr.securent.service;

import com.gmr.securent.entity.RentRequest;
import com.gmr.securent.entity.Tenant;
import com.gmr.securent.entity.enums.ServiceType;
import com.gmr.securent.repository.RentRequestRepository;
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
    public TenantService(TenantRepository tenantRepository,
                         RentRequestRepository rentRequestRepository) {
        this.tenantRepository = tenantRepository;
        this.rentRequestRepository = rentRequestRepository;
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
        } catch(EmptyResultDataAccessException e) { //user zaten yok, db'den empty result gelmiş
            System.out.println("Tenant "+userId+" doesn't exist"); //istersek loglayabiliriz
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
    public void sendRentingRequestToLandlord(Integer tenantId,
                                             Integer landlordId,
                                             Integer houseId,
                                             ServiceType serviceType) {
        // Find the tenant
        Tenant tenant = tenantRepository
                .findById(tenantId)
                .orElseThrow(() -> new RuntimeException("Tenant not found with ID: " + tenantId));

        // Create a new RentRequest object
        RentRequest rentRequest = new RentRequest();
        rentRequest.setServiceType(serviceType);
        rentRequest.setHouseID(houseId);
        rentRequest.setTenantID(tenantId);
        rentRequest.setLandlordID(landlordId);

        // Save the RentRequest object
        rentRequestRepository.save(rentRequest);
    }

}