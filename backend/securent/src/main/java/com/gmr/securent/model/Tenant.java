package com.gmr.securent.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Tenant extends PropertyParticipant {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    @Column
    private List<House> housesRented = new ArrayList<>();
    @Column
    private boolean isDepositPaid;
    @Column
    private double depositAmount;

    public Tenant(String firstName, String lastName, String password, String emailAddress, String phoneNo, int TCK) {
        super(firstName, lastName, password, emailAddress, phoneNo, TCK);
        housesRented = null;
    }

    public void setIsDepositPaid(boolean b) {
        isDepositPaid = b;
    }

    public void setDepositAmount(double amount) {
        depositAmount = amount;
    }
//    + payDeposit(amount: Integer): void
//+ sendRentingRequestToLandlord(rentRequest: RentRequest): void
//+ cancelRentingRequest(rentRequest: RentRequest): void
//+ requestRentalService(rentRequest: RentRequest): void
//+ requestEvaluationOfHouseConditions(rentRequest: RentRequest): void
//+ requestRentPriceToBeRecalculated(rentRequest: RentRequest): void
//+ acceptExtention(renewContract: Boolean): void
//+ reportAd(rentalAd: RentalAd): void
//+ rateRealEstateAgent(agentId: Integer): void
}