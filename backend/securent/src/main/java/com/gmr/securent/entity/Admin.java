package com.gmr.securent.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Entity
@DiscriminatorValue("ADMIN")
@Data
public class Admin extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer adminId;

    public Admin(String firstName, String lastName, String password, String emailAddress, String phoneNo, int tck) {
        super(firstName, lastName, password, emailAddress, phoneNo, tck);
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
