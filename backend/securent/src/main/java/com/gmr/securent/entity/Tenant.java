package com.gmr.securent.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "tenant")
public class Tenant extends User {
    @Column(name = "deposit_payment_status")
    private boolean depositPaymentStatus;

    @Column(name = "deposit_amount")
    private Double depositAmount;
}