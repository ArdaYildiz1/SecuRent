package com.gmr.securent.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "landlord")
public class Landlord {
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

//    public int getUserId() {
//        return userId;
//    }
//
//    public List<House> getHouses() {
//        return houses;
//    }
//
//    public void registerHouse() {
//        // TODO
//        // params not added to avoid error
//    }
//
//    public void createRentalAd() {
//        // TODO
//        // params not added to avoid error
//    }
//
//    public void deleteOwnedHouse(int houseID) {
//        // TODO
//    }
//
//    public void updateHouse(int houseID) {
//        // TODO
//    }
//
//    public void deleteRentalAd() {
//        // TODO
//        // params not added to avoid error
//    }
//
//    public void updateRentalAd(){
//        // TODO
//        // params not added to avoid error
//    }
//
//    public void confirmRentingRequest() {
//        // TODO
//        // params not added to avoid error
//    }
//
//    public void rejectRentingRequest() {
//        // TODO
//        // params not added to avoid error
//    }
//    public void uploadContract() {
//        // TODO
//        // params not added to avoid error
//    }
//    public void acceptExtention(boolean renewContract) {
//        // TODO
//    }
//    public void rateRealEstateAgent(int agentId) {
//        // TODO
//    }
}