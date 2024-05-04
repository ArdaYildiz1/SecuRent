package com.gmr.securent.entity;

import com.gmr.securent.entity.enums.Heating;
import com.gmr.securent.entity.enums.HouseType;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "rental_ad")
public class RentalAd {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ad_id")
    private Integer adId;
    @Column(name = "landlord_id")
    Integer landlordId;
    @Enumerated(EnumType.STRING)
    @Column(name = "house_type")
    HouseType houseType;
    @Column(name = "title")
    String title;
    @Column(name = "description")
    String description;
    @Column(name = "price")
    Double price;
    @Column(name = "address")
    String address;
    @Column(name = "ad_date")
    LocalDate adDate;
    @Column(name = "area_gross")
    double areaGross;
    @Column(name = "area_net")
    double areaNet;
    @Column(name = "area_open_space")
    double areaOpenSpace;
    @Column(name = "number_of_rooms")
    int numberOfRooms;
    @Column(name = "building_age")
    int buildingAge;
    @Column(name = "flat_number")
    int flatNumber;
    @Enumerated(EnumType.STRING)
    @Column(name = "heating")
    Heating heating;
    @Column(name = "number_of_bathrooms")
    int numberOfBathrooms;
    @Column(name = "have_balcony")
    boolean haveBalcony;
    @Column(name = "have_furniture")
    boolean haveFurniture;
    @Column(name = "in_a_site")
    boolean inASite;
    @Column(name = "site_name")
    String siteName;
    @Column(name = "rent_amount")
    double rentAmount;
}
