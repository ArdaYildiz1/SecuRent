package com.gmr.securent.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "baseEntity")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "entity_type", discriminatorType = DiscriminatorType.STRING)
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer entityID;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "password")
    private String password;

    @Column(name = "emailAddress")
    private String emailAddress;

    @Column(name = "phoneNo")
    private String phoneNo;

    @Column(name = "tck")
    private int tck;

    @Column(name = "profilePhoto")
    private int profilePhoto;

    // Constructors, getters, and setters
    public BaseEntity(String firstName, String lastName, String password, String emailAddress, String phoneNo, int tck, int profilePhoto) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.emailAddress = emailAddress;
        this.phoneNo = phoneNo;
        this.tck = tck;
        this.profilePhoto = profilePhoto;
    }

    public BaseEntity(String firstName, String lastName, String password, String emailAddress, String phoneNo, int tck) {
        this(firstName, lastName, password, emailAddress, phoneNo, tck, 0);
    }
}
