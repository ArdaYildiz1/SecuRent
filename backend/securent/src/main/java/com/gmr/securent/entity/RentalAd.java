package com.gmr.securent.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "rentalAds")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RentalAd {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer rentalAdID;

    @Column(name = "rentPrice")
    private double rentPrice;

    @ManyToOne
    @JoinColumn(name = "houseId")
    private House houseInTheRentalAd;

    @Column(name = "description")
    private String description;
}