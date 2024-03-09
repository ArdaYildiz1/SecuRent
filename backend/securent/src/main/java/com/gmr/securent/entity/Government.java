package com.gmr.securent.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@EqualsAndHashCode(callSuper = true)
@Entity
@DiscriminatorValue("GOVERNMENT")
@Data
public class Government extends BaseEntity {
    private Integer governmentId;

//    @OneToMany(mappedBy = "government")
//    private List<Expert> assignedExperts = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "deposits_collected", joinColumns = @JoinColumn(name = "government_id"))
    @MapKeyColumn(name = "deposit_key")
    @Column(name = "deposit_value")
    private Map<String, Double> depositsCollected = new HashMap<>();

    public Government(String firstName, String lastName, String password, String emailAddress, String phoneNo, int tck) {
        super(firstName, lastName, password, emailAddress, phoneNo, tck);
        this.governmentId = super.getEntityID();
    }

//    public void assignExpert() {
//        // TODO
//        // params not added to avoid error
//    }
//
//    @Override
//    public void assignExpert(House house) {
//
//    }
//
//    public void monitorContracts() {
//        // TODO
//        // params not added to avoid error
//    }
//
//    public void manageDeposits(){
//
//    }
//
//    public void redistributeDeposits(){
//        // TODO
//        // params not added to avoid error
//    }
//
//    @Override
//    public String disputeResolution(House house) {
//        return null;
//    }
//
//    @Override
//    public double determinePrice(House house) {
//        return 0;
//    }
//
//    @Override
//    public void confirmContract(RentalContract contract) {
//
//    }
}