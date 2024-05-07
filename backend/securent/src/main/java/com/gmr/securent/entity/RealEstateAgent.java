package com.gmr.securent.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "real_estate_agent")
public class RealEstateAgent extends User {
    @Column(name = "area_of_operations")
    private String areaOfOperations;

    @Column(name = "rating")
    private Double rating = 0.0;

    @Column(name = "rating_count")
    private int ratingCount = 0;
}
