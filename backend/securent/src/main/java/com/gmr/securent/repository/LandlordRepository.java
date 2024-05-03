package com.gmr.securent.repository;

import com.gmr.securent.entity.Landlord;
import com.gmr.securent.entity.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LandlordRepository extends JpaRepository<Landlord, Integer> {
    Landlord findByEmailAddress(String email);

}
