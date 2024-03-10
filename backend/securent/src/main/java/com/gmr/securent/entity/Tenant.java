package com.gmr.securent.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tenant")
public class Tenant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer entityid;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "password")
    private String password;

    @Column(name = "email_address")
    private String emailAddress;

    @Column(name = "phone_no")
    private String phoneNo;

    @Column(name = "tck")
    private int tck;

    @Column(name = "is_deposit_paid")
    private boolean isDepositPaid;

    @Column(name = "deposit_amount")
    private Double depositAmount;

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