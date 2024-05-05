package com.gmr.securent.service;

import com.gmr.securent.entity.Expert;
import com.gmr.securent.entity.Government;
import com.gmr.securent.entity.House;
import com.gmr.securent.entity.RealEstateAgentOperations;
import com.gmr.securent.entity.RentRequest;
import com.gmr.securent.entity.RentalContract;
import com.gmr.securent.entity.Tenant;
import com.gmr.securent.entity.enums.ServiceType;
import com.gmr.securent.repository.ExpertRepository;
import com.gmr.securent.repository.GovernmentRepository;
import com.gmr.securent.repository.HouseRepository;
import com.gmr.securent.repository.RentalContractRepository;
import com.gmr.securent.repository.TenantRepository;
import com.gmr.securent.service.interfaces.GovernmentInterface;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class GovernmentService implements GovernmentInterface {

    // Inject necessary dependencies
    private TenantRepository tenantRepository;
    private GovernmentRepository governmentRepository;
    private HouseRepository houseRepository;
    private ExpertRepository expertRepository;
    private RentalContractRepository rentalContractRepository;

    public GovernmentService(TenantRepository tenantRepository,
            GovernmentRepository governmentRepository,
            HouseRepository houseRepository,
            ExpertRepository expertRepository,
            RentalContractRepository rentalContractRepository) {

        this.governmentRepository = governmentRepository;
        this.houseRepository = houseRepository;
        this.expertRepository = expertRepository;
        this.rentalContractRepository = rentalContractRepository;
    }

    @Override
    public Government getGovernment(Integer userId) {
        return governmentRepository.findById(userId).orElse(null);
    }

    @Override
    public Government saveGovernment(Government newGovernment) {
        return governmentRepository.save(newGovernment);
    }

    @Override
    public Government updateGovernment(Integer governmentId, Government newGovernment) {
        Optional<Government> government = governmentRepository.findById(governmentId);
        if (government.isPresent()) {
            Government foundGovernment = government.get();
            foundGovernment.setFirstName(newGovernment.getFirstName());
            foundGovernment.setLastName(newGovernment.getLastName());
            foundGovernment.setPassword(newGovernment.getPassword());
            foundGovernment.setPhoneNo(newGovernment.getPhoneNo());
            foundGovernment.setEmailAddress(newGovernment.getEmailAddress());
            foundGovernment.setTck(newGovernment.getTck());
            return foundGovernment;
        } else {
            throw new RuntimeException("Government not found with ID: " + governmentId);
        }
    }

    @Override
    public void deleteById(Integer governmentId) {
        try {
            governmentRepository.deleteById(governmentId);
        } catch (EmptyResultDataAccessException e) {
            System.out.println("Government with ID: " + governmentId + " doesn't exist");
        }
    }

    @Override
    public void assignExpert(House house, Integer agentId) {

        // Find the expert
        Expert expert = expertRepository.findById(agentId)
                .orElseThrow(() -> new RuntimeException("Expert not found with ID: " +
                        agentId));

        expert.setAssignedToAHouse(true);
        // house.setExpert(expert);
    }

    @Override
    public void monitorContracts() {
        // get all rental contracts
        List<RentalContract> rentalContracts = rentalContractRepository.findAll();

        for (RentalContract contract : rentalContracts) {
            // Perform monitoring tasks here

            // check whether the uploaded documents are valid or not
            if (contract.getLandlordTCK() == null || contract.getLandlordTCK() <= 0) {
                System.out.println("Warning: invalid landlord TCK detected in contract ID: "
                        + contract.getContractID());
            }
            if (contract.getTenantTCK() == null || contract.getTenantTCK() <= 0) {
                System.out.println("Warning: invalid tenant TCK detected in contract ID: " +
                        contract.getContractID());
            }
            if (contract.getRentAmount() <= 0) {
                System.out.println("Warning: invalid rent amount detected in contract ID: " +
                        contract.getContractID());
            }

            LocalDate startDate = contract.getStartDate();
            LocalDate endDate = contract.getEndDate();

            if (startDate == null || startDate.isAfter(LocalDate.now())) {
                System.out.println("Warning: invalid start date detected in contract ID: " +
                        contract.getContractID());
            }
            if (endDate == null || endDate.isBefore(startDate)) {
                System.out.println("Warning: invalid end date detected in contract ID: " +
                        contract.getContractID());
            }
        }

    }

    @Override
    public void manageDeposits() {

    }

    public void redistributeDeposits() {
        List<RentalContract> allContracts = rentalContractRepository.findAll();
        List<RentalContract> endedContracts = new ArrayList<RentalContract>();

        // find ended contracts
        for (RentalContract contract : endedContracts) {
            LocalDate endContract = contract.getEndDate();
            LocalDate currentDate = LocalDate.now();
            if (endContract.isBefore(currentDate)) {
                endedContracts.add(contract); // if contract is ended, add it to the array
            }
        }

        // for (RentalContract contract : endedContracts) {
        // Check if the house is damaged
        // boolean isDamaged = checkHouseDamage(contract.getHouse());

        // if (!isDamaged) {
        // // Redistribute the deposit to the tenant
        // double depositAmount = contract.getDepositAmount();
        // Integer tenantTCK = contract.getTenantTCK();

        // // Perform deposit redistribution logic here

        // rentalContractRepository.save(contract);
        // }
        // }
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
    public String disputeResolution(House house) {
        return "";
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method
        // 'disputeResolution'");
    }

    @Override
    public double determinePrice(House house) {
        return 0;
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method
        // 'determinePrice'");
    }

    @Override
    public void confirmContract(RentalContract contract) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method
        // 'confirmContract'");
    }
}