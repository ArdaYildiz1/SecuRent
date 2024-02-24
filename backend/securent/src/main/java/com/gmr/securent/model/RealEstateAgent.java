package com.gmr.securent.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class RealEstateAgent extends PropertyParticipant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int agentId;
    String areaOfOperations;
    List<RentRequest> requests;
    double rating;

    public RealEstateAgent(String firstName, String lastName, String password, String emailAddress, String phoneNo, int TCK, String areaOfOperations) {
        super(firstName, lastName, password, emailAddress, phoneNo, TCK);
        this.areaOfOperations = areaOfOperations;
        requests = null;
    }

    public boolean returnDepositToTenant(int houseId) {
        // TODO
        return true;
    }

    public void assistRentalProcess(int serviceId) {
        // TODO
    }

    public void assistConflictResolution(int serviceId) {
        // TODO
    }
}
