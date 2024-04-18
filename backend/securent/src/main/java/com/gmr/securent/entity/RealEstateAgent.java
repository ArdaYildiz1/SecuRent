package com.gmr.securent.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "real_estate_agent")
public class RealEstateAgent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer entityID;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "password")
    private String password;

    @Column(name = "email_address")
    private String emailAddress;

    @Column(name = "phone_no")
    private String phoneNo;

    @Column(name = "tck")
    private int tck;

    @Column(name = "area_of_operations")
    private String areaOfOperations;

    @Column(name = "rating")
    private Double rating;

    @Column(name = "rating_count")
    private int ratingCount = 0;

//
//    public void assistRentalProcess(int serviceId) {
//        // TODO
//    }
//
//    public void assistConflictResolution(int serviceId) {
//        // TODO
//    }
}
