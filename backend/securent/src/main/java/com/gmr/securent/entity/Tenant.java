package com.gmr.securent.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Tenant extends PropertyParticipant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    @OneToMany(mappedBy = "tenant", cascade = CascadeType.ALL)
    private List<RentalContract> rentalContracts = new ArrayList<>();

    @Column(name = "isDepositPaid")
    private boolean isDepositPaid;

    @Column(name = "depositAmount")
    private Double depositAmount;

    public Tenant(String firstName, String lastName, String password, String emailAddress, String phoneNo, Integer TCK) {
        super(firstName, lastName, password, emailAddress, phoneNo, TCK);
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