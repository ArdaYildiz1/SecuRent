package com.gmr.securent.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.awt.*;

@Entity
@NoArgsConstructor
public class BaseEntity {
    @Id
    private int entityID;
    private String firstName;
    private String lastName;
    private String password;
    @Column(unique = true)
    private String emailAddress;
    @Column(unique = true)
    private String phoneNo;
    @Column(unique = true)
    private int TCK;
    private Image profilePhoto;

    public BaseEntity(String firstName,
                      String lastName,
                      String password,
                      String emailAddress,
                      String phoneNo,
                      int TCK,
                      Image profilePhoto) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.emailAddress = emailAddress;
        this.phoneNo = phoneNo;
        this.TCK = TCK;
        this.profilePhoto = profilePhoto;
    }
    public BaseEntity(String firstName,
                      String lastName,
                      String password,
                      String emailAddress,
                      String phoneNo,
                      int TCK) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.emailAddress = emailAddress;
        this.phoneNo = phoneNo;
        this.TCK = TCK;
    }
}
