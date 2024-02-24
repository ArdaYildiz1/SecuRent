package com.gmr.securent.models;

import java.awt.Image; // Added just to remove error, might be handled differently

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
@Entity
public abstract class User {
    @Id
    private int entityID;
    private String firstName;
    private String lastName;
    private String password;
    @Column(unique = true)
    private String emailAddress;
    @Column(unique = true)
    private String phoneNo;
    @Column(unique = true)
    private int TCK;
    private Image profilePhoto;

    public void register() {
        // TODO
    }

    public void login() {
        // TODO
    }

    public void logout() {
        // TODO
    }

    public void deleteAccount() {
        // TODO
    }
}
