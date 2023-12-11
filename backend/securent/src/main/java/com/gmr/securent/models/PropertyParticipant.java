package com.gmr.securent.models;

import jakarta.persistence.Entity;

@Entity
public abstract class PropertyParticipant extends User {
    public PropertyParticipant(String firstName, String lastName, String password, String emailAddress, String phoneNo, int TCK) {
        super(firstName, lastName, password, emailAddress, phoneNo, TCK);
    }

    public void searchHouse()  {
        // TODO
        // houseProperties parameter not added to avoid error
    }
}
