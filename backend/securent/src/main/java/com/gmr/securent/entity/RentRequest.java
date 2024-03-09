package com.gmr.securent.entity;

import com.gmr.securent.entity.enums.ServiceType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "rentRequests")
@AllArgsConstructor
@NoArgsConstructor
public class RentRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer serviceID;

    @Column(name = "serviceType")
    @Enumerated(EnumType.STRING)
    private ServiceType serviceType;

    @Column(name = "houseID")
    private Integer houseID;
}

