package com.gmr.securent.entity;

import jakarta.persistence.*;
import lombok.Data;

@Table(name = "house")
@Entity
@Data
public class House {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer houseId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "adId")
    private HouseProperties houseProperties;

    public House(HouseProperties houseProperties) {
        this.houseProperties = houseProperties;
    }

//    public RentalStatus rentalStatus = RentalStatus.placeholder;

}
