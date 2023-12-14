package com.gmr.securent.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Government extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int governmentID;
    private List<Expert> assignedExperts;
    private Map<String, Double> depositsCollected;

    public Government(String firstName, String lastName, String password, String emailAddress, String phoneNo, int TCK) {
        super(firstName, lastName, password, emailAddress, phoneNo, TCK);
        depositsCollected = null;
    }

    public void assignExpert() {
        // TODO
        // params not added to avoid error
    }

    public void monitorContracts() {
        // TODO
        // params not added to avoid error
    }

    public void redistributeDeposits(){
        // TODO
        // params not added to avoid error
    }

    public void confirmContract() {
        // TODO
        // params not added to avoid error
    }

    abstract double determinePrice() {
        // TODO
        // params not added to avoid error
    }
    public void resolveConflict() {
        // TODO
        // params not added to avoid error
    }
}