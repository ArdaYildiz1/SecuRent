package com.gmr.securent.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gmr.securent.entity.RentalAd;

public interface RentalAdRepository extends JpaRepository<RentalAd, Integer> {
    RentalAd findByHouseID(Integer houseId);
}
