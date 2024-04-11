package com.gmr.securent.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "rental_ad")
public class RentalAd {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer rentalAdID;

    @Column(name = "rent_price")
    private double rentPrice;

    @Column(name = "house_id")
    private Integer houseID;

    @Column(name = "description")
    private String description;
}