package com.gmr.securent.entity;

import com.gmr.securent.entity.enums.Heating;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "house")
public class House {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer houseId;
    private Integer landlordId;
    private Integer tenantId;
    private String address;
    private LocalDate adDate;
    private double areaGross;
    private double areaNet;
    private double areaOpenSpace;
    private int numberOfRooms;
    private int buildingAge;
    private int flatNumber;
    @Enumerated(EnumType.STRING)
    private Heating heating;
    private int numberOfBathrooms;
    private boolean balconyIsPresent;
    private boolean furnitureIsPresent;
    private boolean insideASite;
    private String siteName;
    private double currentAmount;
}
