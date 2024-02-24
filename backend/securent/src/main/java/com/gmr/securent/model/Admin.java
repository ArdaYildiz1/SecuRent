package com.gmr.securent.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Admin extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int adminId;

    public Admin(String firstName, String lastName, String password, String emailAddress, String phoneNo, int TCK) {
        super(firstName, lastName, password, emailAddress, phoneNo, TCK);
    }

    public void openGovernmentAccount() {
        // TODO
    }

    public void listUsers() {
        // TODO
    }

    public void updateUsers() {
        // TODO
    }
}
