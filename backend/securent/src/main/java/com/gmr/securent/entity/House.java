package com.gmr.securent.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "house")
public class House {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer houseId;

    private Integer landlordID;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "house_properties_id")
    private HouseProperties houseProperties;
}
