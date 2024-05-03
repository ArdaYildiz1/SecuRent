package com.gmr.securent.entity;

import java.time.LocalDate;

import com.gmr.securent.entity.enums.Heating;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
    @Column(name = "house_id")
    private Integer houseId;

    @Column(name = "landlord_id")
    private Integer landlordID;

    @Column(name = "tenant_id")
    private Integer tenantId;

    @Column(name = "address")
    private String address;

    @Column(name = "ad_date")
    private LocalDate adDate;

    @Column(name = "area_gross")
    private double areaGross;

    @Column(name = "area_net")
    private double areaNet;

    @Column(name = "area_open_space")
    private double areaOpenSpace;

    @Column(name = "number_of_rooms")
    private int numberOfRooms;

    @Column(name = "building_age")
    private int buildingAge;

    @Column(name = "flat_number")
    private int flatNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "heating")
    private Heating heating;

    @Column(name = "number_of_bathrooms")
    private int numberOfBathrooms;

    @Column(name = "balcony_is_present")
    private boolean balconyIsPresent;

    @Column(name = "furniture_is_present")
    private boolean furnitureIsPresent;

    @Column(name = "inside_a_site")
    private boolean insideASite;

    @Column(name = "site_name")
    private String siteName;

    @Column(name = "rent_price")
    private double rentPrice;

    @Column(name = "ad_title")
    private String adTitle;

    @Column(name = "landlord_name")
    private String landlordName;

    @Column(name = "landlord_phone_number")
    private String landlordPhoneNumber;

    @Column(name = "ad_details")
    private String adDetails;
}

