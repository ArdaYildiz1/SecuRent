package com.gmr.securent.entity;

import com.gmr.securent.entity.enums.GovernmentServiceType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "assigned_jobs")
public class AssignedJobs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer jobId;

    @Column(name = "service_type")
    @Enumerated(EnumType.STRING)
    private GovernmentServiceType serviceType;

    @Column(name = "service_accepted")
    private boolean serviceAccepted;

    @Column(name = "newly_created")
    private boolean newlyCreated;

    @Column(name = "house_ID")
    private Integer houseID;

    @Column(name = "tenant_ID")
    private Integer tenantID;

    @Column(name = "landlord_ID")
    private Integer landlordID;

    @Column(name = "government_ID")
    private Integer governmentID;
}
