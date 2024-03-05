package com.gmr.securent.model;

import com.gmr.securent.model.enums.ServiceType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class RentRequest {
    @Id
    @Column
    private int serviceID;
    @Column
    private ServiceType serviceType;
    @Column
    private int houseID;
}
