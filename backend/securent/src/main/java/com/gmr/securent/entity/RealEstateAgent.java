package com.gmr.securent.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class RealEstateAgent extends BaseEntity {
    private Integer realEstateAgentId;
    @Column(name = "areaOfOperations")
    private String areaOfOperations;
//    @OneToMany(mappedBy = "realEstateAgent", cascade = CascadeType.ALL)
//    private List<RentRequest> requests = new ArrayList<>();
    @Column(name = "rating")
    private Double rating;

    public RealEstateAgent(String firstName, String lastName, String password, String emailAddress, String phoneNo, Integer TCK, String areaOfOperations) {
        super(firstName, lastName, password, emailAddress, phoneNo, TCK);
        this.areaOfOperations = areaOfOperations;
        this.realEstateAgentId = super.getEntityID();
    }


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
