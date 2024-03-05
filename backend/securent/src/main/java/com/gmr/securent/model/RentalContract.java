package com.gmr.securent.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class RentalContract {
    @Id
    @Column
    private int contractID;
    @Column
    private int landlordTCK;
    @Column
    private int tenantTCK;
    @Column
    private double rentAmount;
}