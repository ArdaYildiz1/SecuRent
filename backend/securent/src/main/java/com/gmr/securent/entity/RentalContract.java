package com.gmr.securent.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "rentalContract")
@AllArgsConstructor
@NoArgsConstructor
public class RentalContract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer contractID;

    @Column(name = "landlordTCK")
    private Integer landlordTCK;

    @Column(name = "tenantTCK")
    private Integer tenantTCK;

    @Column(name = "rentAmount")
    private double rentAmount;

    // Add start and end date fields if applicable
    @Column(name = "startDate")
    private LocalDate startDate;

    @Column(name = "endDate")
    private LocalDate endDate;
}
