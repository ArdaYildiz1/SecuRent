package com.gmr.securent.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Entity
@DiscriminatorValue("HOUSE")
@Data
public class House extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer houseId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "house_properties_id")
    private HouseProperties houseProperties;

    public House(String firstName, String lastName, String password, String emailAddress, String phoneNo, int tck, int profilePhoto, HouseProperties houseProperties) {
        super(firstName, lastName, password, emailAddress, phoneNo, tck, profilePhoto);
        this.houseProperties = houseProperties;
    }

//    public RentalStatus rentalStatus = RentalStatus.placeholder;

}
