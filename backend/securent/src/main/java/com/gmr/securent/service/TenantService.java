package com.gmr.securent.service;

import com.gmr.securent.entity.*;
import com.gmr.securent.entity.enums.ServiceType;
import com.gmr.securent.repository.*;
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
    RealEstateAgentOperationsRepository realEstateAgentOperationsRepository;
    RealEstateAgentRepository realEstateAgentRepository;
    HouseService houseService;
    HouseRepository houseRepository;

    public TenantService(TenantRepository tenantRepository,
            RentRequestRepository rentRequestRepository,
            RealEstateAgentOperationsRepository realEstateAgentOperationsRepository,
            RealEstateAgentRepository realEstateAgentRepository,
            HouseService houseService,
            HouseRepository houseRepository) {
        this.tenantRepository = tenantRepository;
        this.rentRequestRepository = rentRequestRepository;
        this.realEstateAgentOperationsRepository = realEstateAgentOperationsRepository;
        this.realEstateAgentRepository = realEstateAgentRepository;
        this.houseService = houseService;
        this.houseRepository = houseRepository;
    }

    @Override
    public List<Tenant> getAllTenants() {
        return tenantRepository.findAll();
    }

    public House getRentedHouse(Integer tenantId) {
        List<House> rentedHouses = houseRepository.findAllByTenantId(tenantId);
        if (!rentedHouses.isEmpty()) {
            return rentedHouses.get(0); // Return the first rented house
        }
        return null; // No rented house found for the tenant
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
    public Tenant getOneTenantByEmailAndPassword(String email, String password) {
        return tenantRepository.findByEmailAddressAndPassword(email, password);
    }

    @Override
    public Tenant updateOneTenant(Integer userId, Tenant newTenant) {
        Optional<Tenant> tenant = tenantRepository.findById(userId);
        if (tenant.isPresent()) {
            Tenant foundTenant = tenant.get();
            foundTenant.setFirstName(newTenant.getFirstName());
            foundTenant.setLastName(newTenant.getLastName());
            foundTenant.setPassword(newTenant.getPassword());
            foundTenant.setPhoneNo(newTenant.getPhoneNo());
            foundTenant.setEmailAddress(newTenant.getEmailAddress());
            foundTenant.setTck(newTenant.getTck());
            foundTenant.setDepositPaymentStatus(newTenant.isDepositPaymentStatus());
            tenantRepository.save(foundTenant);
            return foundTenant;
        } else {
            throw new RuntimeException("Tenant not found with ID: " + userId);
        }
    }

    @Override
    public void deleteById(Integer userId) {
        try {
            tenantRepository.deleteById(userId);
        } catch (EmptyResultDataAccessException e) {
            System.out.println("Tenant " + userId + " doesn't exist");
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
    public void sendRentingRequestToLandlord(Integer tenantId, Integer landlordID, Integer realEstateAgentID,
            Integer houseId) {
        // Find the tenant
        Tenant tenant = tenantRepository
                .findById(tenantId)
                .orElseThrow(() -> new RuntimeException("Tenant not found with ID: " + tenantId));

        // Create a new RentRequest object
        RentRequest rentRequest = new RentRequest();
        rentRequest.setTenantID(tenantId);
        rentRequest.setLandlordID(landlordID);
        rentRequest.setRealEstateAgentID(realEstateAgentID);
        rentRequest.setHouseID(houseId);

        // Save the RentRequest object
        rentRequestRepository.save(rentRequest);
    }

    @Override
    public void cancelRentingRequestToLandlord(Integer rentRequestId) {
        rentRequestRepository.deleteById(rentRequestId);
    }

    @Override
    public List<RealEstateAgentOperations> getAllRealEstateAgentOperationsForTenant(Integer tenantId) {
        return realEstateAgentOperationsRepository.findAllByTenantID(tenantId);
    }

    @Override
    public void sendRealEstateAgentOperationRequest(Integer tenantId,
            Integer landlordId,
            Integer realEstateAgentId,
            Integer houseId,
            ServiceType serviceType) {
        // Find the tenant
        Tenant tenant = tenantRepository
                .findById(tenantId)
                .orElseThrow(() -> new RuntimeException("Tenant not found with ID: " + tenantId));

        // Create a new RealEstateAgentOperations object
        RealEstateAgentOperations realEstateAgentOperations = new RealEstateAgentOperations();
        realEstateAgentOperations.setServiceType(serviceType);
        realEstateAgentOperations.setTenantID(tenantId);
        realEstateAgentOperations.setLandlordID(landlordId);
        realEstateAgentOperations.setRealEstateAgentID(realEstateAgentId);
        realEstateAgentOperations.setHouseID(houseId);

        // Save the RealEstateAgentOperations object
        realEstateAgentOperationsRepository.save(realEstateAgentOperations);
    }

    @Override
    public void cancelRealEstateAgentOperationRequest(Integer serviceId) {
        realEstateAgentOperationsRepository.deleteById(serviceId);
    }

    @Override
    public void rateRealEstateAgent(Integer agentId, Double newRating) {

        // Find the real estate agent
        RealEstateAgent agent = realEstateAgentRepository.findById(agentId)
                .orElseThrow(() -> new RuntimeException("Real Estate Agent not found with ID: " + agentId));

        // Update the rating
        agent.setRating((agent.getRatingCount() * agent.getRating() + newRating) / (agent.getRatingCount() + 1));
        agent.setRatingCount(agent.getRatingCount() + 1);

        // Save the updated real estate agent
        realEstateAgentRepository.save(agent);
    }
}