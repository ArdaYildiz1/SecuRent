package com.gmr.securent.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Tenant extends PropertyParticipant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    List<House> housesRented = new ArrayList<>();

    public Tenant(String firstName, String lastName, String password, String emailAddress, String phoneNo, int TCK) {
        super(firstName, lastName, password, emailAddress, phoneNo, TCK);
        housesRented = null;
    }

    public List<House> getHousesRented() {
        return housesRented;
    }

    public void payDeposit(int amount) {
        // TODO
    }

    public void sendRentingRequestToLandlord(RentRequest rentRequest) {
        // TODO
    }

    public void cancelRentingRequestToLandlord(RentRequest rentRequest) {
        // TODO
    }

    public void requestRentalService() {
        // TODO
        // houseService property not added to avoid error
    }

    public void requestRentPriceToBeRecalculated() {
        // TODO
        // houseService property not added to avoid error
    }

    public void acceptExtension(boolean renewContract) {
        // TODO
    }

    public void reportAd() {
        // TODO
        // rentalAd parameter not added to avoid error
    }

    public void rateRealEstateAgent(int agentId) {
        // TODO
    }
}