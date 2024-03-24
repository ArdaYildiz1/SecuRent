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
@Table(name = "rental_service")
public class RentalService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer serviceID;

    @Column(name = "service_type")
    @Enumerated(EnumType.STRING)
    private ServiceType serviceType = ServiceType.RENTAL_SERVICE;

    @Column(name = "house_ID")
    private Integer houseID;

    @Column(name = "tenant_ID")
    private Integer tenantID;

    @Column(name = "real_estate_agent_ID")
    private Integer realEstateAgentID;
}
