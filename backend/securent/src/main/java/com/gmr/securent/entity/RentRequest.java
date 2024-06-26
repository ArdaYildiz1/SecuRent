package com.gmr.securent.entity;

import com.gmr.securent.entity.enums.ServiceType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "rent_request")
public class RentRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer serviceID;

    @Column(name = "service_type")
    @Enumerated(EnumType.STRING)
    private ServiceType serviceType = ServiceType.RENT_REQUEST;

    @Column(name = "service_accepted")
    private boolean serviceAccepted;

    @Column(name = "house_ID")
    private Integer houseID;

    @Column(name = "tenant_ID")
    private Integer tenantID;

    @Column(name = "landlord_ID")
    private Integer landlordID;

    @Column(name = "real_estate_agent_ID")
    private Integer realEstateAgentID;
}
