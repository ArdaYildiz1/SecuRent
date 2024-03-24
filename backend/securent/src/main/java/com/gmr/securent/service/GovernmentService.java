package com.gmr.securent.government;

import com.gmr.securent.entity.House;
import com.gmr.securent.repository.HouseRepository;
import com.gmr.securent.repository.ExpertRepository;
import java.util.List;
import java.util.Optional;

@Service
public class GovernmentService implements GovernmentInterface {

    // Inject necessary dependencies
    GovernmentRepository governmentRepository;
    HouseRepository houseRepository;
    ExpertRepository expertRepository;


    public GovernmentService(GovernmentRepository governmentRepository,  
                            HouseRepository houseRepository, 
                            ExpertRepository expertRepository) {

        this.governmentRepository = governmentRepository;
        this.houseRepository = houseRepository;
        this.expertRepository = expertRepository;
    }

    @Override
    public Government getGovernment() {
        return governmentRepository.findById(userId).orElse(null);
    }
    @Override
    public Government saveGovernment(Government newGovernment) {
        return governmentRepository.save(newGovernment);
    }

    @Override
    public Government updateGovernment(Integer governmentId, Governemnt newGovernment) {
        Optional<Government> government = governmentRepository.findById(governmentId);
        if(government.isPresent()) {
            Government foundGovernment = government.get();
            foundGovernment.setFirstName(newGovernment.getFirstName());
            foundGovernment.setLastName(newGovernment.getLastName());
            foundGovernment.setPassword(newGovernment.getPassword());
            foundGovernment.setPhoneNo(newGovernment.getPhoneNo());
            foundGovernment.setEmailAddress(newGovernment.getEmailAddress());
            foundGovernment.setTck(newGovernment.getTck());
            return foundGovernment;
        }
        else {
            throw new RuntimeException("Government not found with ID: " + governmentId);
        }
    }
    @Override
    public void deleteById(Integer governmentId) {
        try {
            governmentRepository.deleteById(governmentId);
        } catch(EmptyResultDataAccessException e) {
            System.out.println("Government with ID: "+ governmentId +" doesn't exist");
        }
    }

    @Override
    public void assignExpert(House house, Integer agentId){

        // Find the expert
        Expert expert = expertRepository.findById(agentId)
        .orElseThrow(() -> new RuntimeException("Expert not found with ID: " + agentId));

        expert.setAssignedToAHouse(true);
        house.getHouseProperties.setExpert(expert);

        
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
    public List<RealEstateAgentOperations> getAllRealEstateAgentOperationsForTenant(Integer tenantId) {
        return realEstateAgentOperationsRepository.findAllByTenantID(tenantId);
    }
    @Override
    public void sendRealEstateAgentOperationRequest(Integer tenantId,
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
        agent.setRating(agent.getRatingCount() * agent.getRating() + newRating);

        // Save the updated real estate agent
        realEstateAgentRepository.save(agent);
    }
}