package com.gmr.securent.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tenant")
public class Tenant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "entity_id")
    private Integer entityId;

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
    private long tck;

    @Column(name = "deposit_payment_status")
    private boolean depositPaymentStatus;

    @Column(name = "deposit_amount")
    private Double depositAmount;
}