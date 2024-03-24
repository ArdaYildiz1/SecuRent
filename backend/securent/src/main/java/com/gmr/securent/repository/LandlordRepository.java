package com.gmr.securent.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gmr.securent.entity.Landlord;

public interface LandlordRepository extends JpaRepository<Landlord, Integer> {
}
