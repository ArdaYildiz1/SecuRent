package com.gmr.securent.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Expert extends Government {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int agentID;
    private boolean assignedToAHouseCurrently;

    public Expert(String firstName, String lastName, String password, String emailAddress, String phoneNo, int TCK) {
        super(firstName, lastName, password, emailAddress, phoneNo, TCK);
    }

    @Override
    public double determinePrice() {
        // TODO
        // params not added to avoid error
        return 0;
    }
}