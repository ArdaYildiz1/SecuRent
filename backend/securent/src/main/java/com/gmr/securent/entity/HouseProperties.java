package com.gmr.securent.entity;

import com.gmr.securent.entity.enums.Heating;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class HouseProperties {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer housePropertiesId;
    private String address;
    private LocalDate adDate;
    private double areaGross;
    private double areaNet;
    private double areaOpenSpace;
    private int numberOfRooms;
    private int buildingAge;
    private int flatNumber;
    private Heating heating;
    private int numberOfBathrooms;
    private boolean balconyIsPresent;
    private boolean furnitureIsPresent;
    private boolean insideASite;
    private String siteName;
    private double currentAmount;
    private Expert expert;
}

