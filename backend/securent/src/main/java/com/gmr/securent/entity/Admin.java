package com.gmr.securent.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Entity
@DiscriminatorValue("ADMIN")
@Data
public class Admin extends BaseEntity {
    private Integer adminId;

    public Admin(String firstName, String lastName, String password, String emailAddress, String phoneNo, int tck) {
        super(firstName, lastName, password, emailAddress, phoneNo, tck);
        this.adminId = super.getEntityID();
    }

//    public void openGovernmentAccount() {
//        // TODO
//    }
//
//    public void listUsers() {
//        // TODO
//    }
//
//    public void updateUsers() {
//        // TODO
//    }
}
