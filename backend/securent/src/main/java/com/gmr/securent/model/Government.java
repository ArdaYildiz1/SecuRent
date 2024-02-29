package com.gmr.securent.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Entity
@Data
public class Government extends BaseEntity implements GovernmentInterface {
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

    public void manageDeposits(){

    }

    public void redistributeDeposits(){
        // TODO
        // params not added to avoid error
    }

    public void confirmContract() {
        // TODO
        // params not added to avoid error
    }

    public double determinePrice() {
        // TODO
        // params not added to avoid error
        return 0;
    }
    public void resolveConflict() {
        // TODO
        // params not added to avoid error
    }
}