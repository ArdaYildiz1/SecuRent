package com.gmr.securent.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Landlord extends PropertyParticipant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    @OneToMany(mappedBy = "landlord", cascade = CascadeType.ALL)
    private List<House> houses = new ArrayList<>();

    public Landlord(String firstName, String lastName, String password, String emailAddress, String phoneNo, Integer TCK) {
        super(firstName, lastName, password, emailAddress, phoneNo, TCK);
    }


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