package com.gmr.securent.service;

import com.gmr.securent.entity.RealEstateAgent;
import com.gmr.securent.entity.RealEstateAgentOperations;
import com.gmr.securent.repository.RealEstateAgentOperationsRepository;
import com.gmr.securent.repository.RealEstateAgentRepository;
import com.gmr.securent.service.interfaces.RealEstateAgentInterface;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RealEstateAgentService implements RealEstateAgentInterface {

    // Inject necessary dependencies
    RealEstateAgentRepository realEstateAgentRepository;
    RealEstateAgentOperationsRepository realEstateAgentOperationsRepository;

    public RealEstateAgentService(RealEstateAgentRepository realEstateAgentRepository,
                                  RealEstateAgentOperationsRepository realEstateAgentOperationsRepository) {
        this.realEstateAgentRepository = realEstateAgentRepository;
        this.realEstateAgentOperationsRepository = realEstateAgentOperationsRepository;
    }

    @Override
    public List<RealEstateAgent> getAllRealEstateAgents() {
        return realEstateAgentRepository.findAll();
    }
    @Override
    public RealEstateAgent saveOneRealEstateAgent(RealEstateAgent newRealEstateAgent) {
        return realEstateAgentRepository.save(newRealEstateAgent);
    }
    @Override
    public RealEstateAgent getOneRealEstateAgentById(Integer userId) {
        return realEstateAgentRepository.findById(userId).orElse(null);
    }
    @Override
    public RealEstateAgent updateOneRealEstateAgent(Integer userId, RealEstateAgent newRealEstateAgent) {
        Optional<RealEstateAgent> realEstateAgent = realEstateAgentRepository.findById(userId);
        if(realEstateAgent.isPresent()) {
            RealEstateAgent foundRealEstateAgent = realEstateAgent.get();
            foundRealEstateAgent.setFirstName(newRealEstateAgent.getFirstName());
            foundRealEstateAgent.setLastName(newRealEstateAgent.getLastName());
            foundRealEstateAgent.setPassword(newRealEstateAgent.getPassword());
            foundRealEstateAgent.setPhoneNo(newRealEstateAgent.getPhoneNo());
            foundRealEstateAgent.setEmailAddress(newRealEstateAgent.getEmailAddress());
            foundRealEstateAgent.setTck(newRealEstateAgent.getTck());
            realEstateAgentRepository.save(foundRealEstateAgent);
            return foundRealEstateAgent;
        }
        else {
            throw new RuntimeException("RealEstateAgent not found with ID: " + userId);
        }
    }
    @Override
    public void deleteById(Integer userId) {
        try {
            realEstateAgentRepository.deleteById(userId);
        } catch(EmptyResultDataAccessException e) {
            System.out.println("RealEstateAgent "+ userId +" doesn't exist");
        }
    }
    @Override
    public List<RealEstateAgentOperations> getAllRentalServiceRequestsForRealEstateAgent(Integer realEstateAgentId) {
        return realEstateAgentOperationsRepository.findAllByRealEstateAgentID(realEstateAgentId);
    }
    @Override
    public void acceptRentalService(Integer rentalServiceID) {
        RealEstateAgentOperations rentalService = realEstateAgentOperationsRepository.findById(rentalServiceID).
                orElse(null);
        if (rentalService != null) {
            rentalService.setServiceAccepted(true);
            realEstateAgentOperationsRepository.save(rentalService);
        } else {
            throw new RuntimeException("No pending rental service to accept.");
        }
    }
    @Override
    public void rejectRentalService(Integer rentalServiceID) {
        RealEstateAgentOperations rentalService = realEstateAgentOperationsRepository.findById(rentalServiceID).
                orElse(null);
        if (rentalService != null) {
            rentalService.setServiceAccepted(false);
            realEstateAgentOperationsRepository.save(rentalService);
        } else {
            throw new RuntimeException("No pending rental service to accept.");
        }
    }
}