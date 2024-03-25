package com.gmr.securent.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
 
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "rental_contract")
public class RentalContract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer contractID;

    @Column(name = "landlord_tck")
    private Integer landlordTCK;

    @Column(name = "tenant_tck")
    private Integer tenantTCK;

    @Column(name = "rent_amount")
    private double rentAmount;

    // Add start and end date fields if applicable
    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;
}
