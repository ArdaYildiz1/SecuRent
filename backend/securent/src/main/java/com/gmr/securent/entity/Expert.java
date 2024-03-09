package com.gmr.securent.entity;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Entity
@DiscriminatorValue("EXPERT")
@Data
public class Expert extends BaseEntity {
    private Integer agentId;

    @Column(name = "assignedToAHouseCurrently")
    private boolean assignedToAHouseCurrently;

    public Expert(String firstName, String lastName, String password, String emailAddress, String phoneNo, int tck) {
        super(firstName, lastName, password, emailAddress, phoneNo, tck);
        this.agentId = super.getEntityID();
    }

//    @Override
//    public double determinePrice() {
//        // TODO
//        // params not added to avoid error
//        return 0;
//    }
}