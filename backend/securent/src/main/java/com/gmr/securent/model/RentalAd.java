package com.gmr.securent.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class RentalAd {
    @Id
    @Column
    private int rentalAdID;
    @Column
    private double rentPrice;
    @Column
    private House houseInTheRentalAd;
    @Column
    private String description;
}