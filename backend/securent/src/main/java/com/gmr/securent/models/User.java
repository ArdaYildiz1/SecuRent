package com.gmr.securent.models;

import java.awt.Image; // Added just to remove error, might be handled differently

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public abstract class User {
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

    public User(String firstName, String lastName, String password, String emailAddress, String phoneNo, int TCK) {
        setFirstName(firstName);
        setLastName(lastName);
        setPassword(password);
        setEmailAddress(emailAddress);
        setPhoneNo(phoneNo);
        setTCK(TCK);
        setProfilePhoto(null); // I assigned null for now, may be changed later
    }

    public String getFirstName() {
        return firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public int getTCK() {
        return TCK;
    }

    public void setTCK(int tCK) {
        TCK = tCK;
    }

    public Image getProfilePhoto() {
        return profilePhoto;
    }

    public void setProfilePhoto(Image profilePhoto) {
        this.profilePhoto = profilePhoto;
    }

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
