package com.gmr.securent.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Landlord extends PropertyParticipant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    private List<House> houses;

    public Landlord(String firstName, String lastName, String password, String emailAddress, String phoneNo, int TCK) {
        super(firstName, lastName, password, emailAddress, phoneNo, TCK);
        houses = null;
    }

    public int getUserId() {
        return userId;
    }

    public List<House> getHouses() {
        return houses;
    }

    public void registerHouse() {
        // TODO
        // params not added to avoid error
    }

    public void createRentalAd() {
        // TODO
        // params not added to avoid error
    }

    public void deleteOwnedHouse(int houseID) {
        // TODO
    }

    public void updateHouse(int houseID) {
        // TODO
    }

    public void deleteRentalAd() {
        // TODO
        // params not added to avoid error
    }

    public void updateRentalAd(){
        // TODO
        // params not added to avoid error
    }

    public void confirmRentingRequest() {
        // TODO
        // params not added to avoid error
    }

    public void rejectRentingRequest() {
        // TODO
        // params not added to avoid error
    }
    public void uploadContract() {
        // TODO
        // params not added to avoid error
    }
    public void acceptExtention(boolean renewContract) {
        // TODO
    }
    public void rateRealEstateAgent(int agentId) {
        // TODO
    }
}