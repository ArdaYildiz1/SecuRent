package com.gmr.securent.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "government")
public class Government {
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

    @ElementCollection
    @CollectionTable(name = "deposits_collected", joinColumns = @JoinColumn(name = "government_id"))
    @MapKeyColumn(name = "deposit_key")
    @Column(name = "deposit_value")
    private Map<String, Double> depositsCollected = new HashMap<>();

}