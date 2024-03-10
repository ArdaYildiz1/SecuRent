package com.gmr.securent.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

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

//    @OneToMany(mappedBy = "realEstateAgent", cascade = CascadeType.ALL)
//    private List<RentRequest> requests = new ArrayList<>();
//    public boolean returnDepositToTenant(int houseId) {
//        // TODO
//        return true;
//    }
//
//    public void assistRentalProcess(int serviceId) {
//        // TODO
//    }
//
//    public void assistConflictResolution(int serviceId) {
//        // TODO
//    }
}
