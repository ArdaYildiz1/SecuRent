// package com.gmr.securent.service;

// import com.gmr.securent.entity.House;
// import com.gmr.securent.repository.HouseRepository;
// import com.gmr.securent.repository.ExpertRepository;
// import com.gmr.securent.repository.RentalContractRepository;
// import com.gmr.securent.service.interfaces.GovernemntInterface;
// import com.gmr.securent.service.RentalContractService;

// import java.util.List;
// import java.util.Optional;

// @Service
// public class GovernmentService implements GovernmentInterface {

// // Inject necessary dependencies
// private GovernmentRepository governmentRepository;
// private HouseRepository houseRepository;
// private ExpertRepository expertRepository;
// private RentalContractRepository rentalContractRepository;

// public GovernmentService(GovernmentRepository governmentRepository,
// HouseRepository houseRepository,
// ExpertRepository expertRepository,
// RentalContractRepository rentalContractRepository) {

// this.governmentRepository = governmentRepository;
// this.houseRepository = houseRepository;
// this.expertRepository = expertRepository;
// this.rentalContractRepository = rentalContractRepository;
// }

// @Override
// public Government getGovernment() {
// return governmentRepository.findById(userId).orElse(null);
// }
// @Override
// public Government saveGovernment(Government newGovernment) {
// return governmentRepository.save(newGovernment);
// }

// @Override
// public Government updateGovernment(Integer governmentId, Governemnt
// newGovernment) {
// Optional<Government> government =
// governmentRepository.findById(governmentId);
// if(government.isPresent()) {
// Government foundGovernment = government.get();
// foundGovernment.setFirstName(newGovernment.getFirstName());
// foundGovernment.setLastName(newGovernment.getLastName());
// foundGovernment.setPassword(newGovernment.getPassword());
// foundGovernment.setPhoneNo(newGovernment.getPhoneNo());
// foundGovernment.setEmailAddress(newGovernment.getEmailAddress());
// foundGovernment.setTck(newGovernment.getTck());
// return foundGovernment;
// }
// else {
// throw new RuntimeException("Government not found with ID: " + governmentId);
// }
// }
// @Override
// public void deleteById(Integer governmentId) {
// try {
// governmentRepository.deleteById(governmentId);
// } catch(EmptyResultDataAccessException e) {
// System.out.println("Government with ID: "+ governmentId +" doesn't exist");
// }
// }

// @Override
// public void assignExpert(House house, Integer agentId){

// // Find the expert
// Expert expert = expertRepository.findById(agentId)
// .orElseThrow(() -> new RuntimeException("Expert not found with ID: " +
// agentId));

// expert.setAssignedToAHouse(true);
// house.getHouseProperties.setExpert(expert);
// }

// @Override
// public void monitorContracts(){
// // get all rental contracts
// List<RentalContract> rentalContracts = rentalContractRepository.findAll();

// for (RentalContract contract : rentalContracts) {
// // Perform monitoring tasks here

// // check whether the uploaded documents are valid or not
// if (contract.getLandlordTCK() == null || contract.getLandlordTCK() <= 0) {
// System.out.println("Warning: invalid landlord TCK detected in contract ID: "
// + contract.getContractID());
// }
// if (contract.getTenantTCK() == null || contract.getTenantTCK() <= 0) {
// System.out.println("Warning: invalid tenant TCK detected in contract ID: " +
// contract.getContractID());
// }
// if (contract.getRentAmount() <= 0) {
// System.out.println("Warning: invalid rent amount detected in contract ID: " +
// contract.getContractID());
// }

// LocalDate startDate = rentalContract.getStartDate();
// LocalDate endDate = rentalContract.getEndDate();

// if ( startDate == null || startDate.isAfter(LocalDate.now())) {
// System.out.println("Warning: invalid start date detected in contract ID: " +
// contract.getContractID());
// }
// if ( endDate == null || endDate.isBefore(startDate) ) {
// System.out.println("Warning: invalid end date detected in contract ID: " +
// contract.getContractID());
// }
// }

// }

// @Override
// public void manageDeposits(){

// }

// public void redistributeDeposits(){
// List<RentalContract> allContracts =
// rentalContractRepository.findEndedContracts();
// List<RentalContract> endedContracts = new ArrayList<RentalContract>();

// // find ended contracts

// for (RentalContract contract : endedContracts) {
// // Check if the house is damaged
// boolean isDamaged = checkHouseDamage(contract.getHouse());

// if (!isDamaged) {
// // Redistribute the deposit to the tenant
// double depositAmount = contract.getDepositAmount();
// Integer tenantTCK = contract.getTenantTCK();

// // Perform deposit redistribution logic here
// // For example:
// // tenantService.redistributeDeposit(tenantTCK, depositAmount);

// // Update contract status or perform any necessary bookkeeping
// contract.setStatus(ContractStatus.DEPOSIT_REDISTRIBUTED);
// rentalContractRepository.save(contract);
// }
// }

// for (RentalContract contract : endedContracts) {
// // Check if the house is damaged
// boolean isDamaged = checkHouseDamage(contract.getHouse());

// if (!isDamaged) {
// // Redistribute the deposit to the tenant
// double depositAmount = contract.getDepositAmount();
// Integer tenantTCK = contract.getTenantTCK();

// // Perform deposit redistribution logic here
// // For example:
// // tenantService.redistributeDeposit(tenantTCK, depositAmount);

// // Update contract status or perform any necessary bookkeeping
// contract.setStatus(ContractStatus.DEPOSIT_REDISTRIBUTED);
// rentalContractRepository.save(contract);
// }
// }
// }

// @Override
// public void payDeposit(Integer userId, Double amount) {
// Optional<Tenant> tenantOptional = tenantRepository.findById(userId);
// if (tenantOptional.isPresent()) {
// Tenant tenant = tenantOptional.get();
// tenant.setDepositAmount(amount);
// tenant.setDepositPaymentStatus(true);
// tenantRepository.save(tenant);
// } else {
// throw new RuntimeException("Tenant not found with ID: " + userId);
// }
// }

// @Override
// public List<RentRequest> getAllRentingRequestsForTenant(Integer tenantId) {
// return rentRequestRepository.findAllByTenantID(tenantId);
// }
// @Override
// public void sendRentingRequestToLandlord(Integer tenantId, Integer
// landlordId, Integer houseId) {
// // Find the tenant
// Tenant tenant = tenantRepository
// .findById(tenantId)
// .orElseThrow(() -> new RuntimeException("Tenant not found with ID: " +
// tenantId));

// // Create a new RentRequest object
// RentRequest rentRequest = new RentRequest();
// rentRequest.setTenantID(tenantId);
// rentRequest.setLandlordID(landlordId);
// rentRequest.setHouseID(houseId);

// // Save the RentRequest object
// rentRequestRepository.save(rentRequest);
// }
// @Override
// public void cancelRentingRequestToLandlord(Integer rentRequestId) {
// rentRequestRepository.deleteById(rentRequestId);
// }
// @Override
// public List<RealEstateAgentOperations>
// getAllRealEstateAgentOperationsForTenant(Integer tenantId) {
// return realEstateAgentOperationsRepository.findAllByTenantID(tenantId);
// }
// @Override
// public void sendRealEstateAgentOperationRequest(Integer tenantId,
// Integer realEstateAgentId,
// Integer houseId,
// ServiceType serviceType) {
// // Find the tenant
// Tenant tenant = tenantRepository
// .findById(tenantId)
// .orElseThrow(() -> new RuntimeException("Tenant not found with ID: " +
// tenantId));

// // Create a new RealEstateAgentOperations object
// RealEstateAgentOperations realEstateAgentOperations = new
// RealEstateAgentOperations();
// realEstateAgentOperations.setServiceType(serviceType);
// realEstateAgentOperations.setTenantID(tenantId);
// realEstateAgentOperations.setRealEstateAgentID(realEstateAgentId);
// realEstateAgentOperations.setHouseID(houseId);

// // Save the RealEstateAgentOperations object
// realEstateAgentOperationsRepository.save(realEstateAgentOperations);
// }
// @Override
// public void cancelRealEstateAgentOperationRequest(Integer serviceId) {
// realEstateAgentOperationsRepository.deleteById(serviceId);
// }
// @Override
// public void rateRealEstateAgent(Integer agentId, Double newRating) {

// // Find the real estate agent
// RealEstateAgent agent = realEstateAgentRepository.findById(agentId)
// .orElseThrow(() -> new RuntimeException("Real Estate Agent not found with ID:
// " + agentId));

// // Update the rating
// agent.setRating(agent.getRatingCount() * agent.getRating() + newRating);

// // Save the updated real estate agent
// realEstateAgentRepository.save(agent);
// }
// }