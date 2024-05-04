package com.gmr.securent.repository;

import com.gmr.securent.entity.RealEstateAgent;
import com.gmr.securent.entity.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RealEstateAgentRepository extends JpaRepository<RealEstateAgent, Integer> {
    RealEstateAgent findByEmailAddress(String email);

    List<RealEstateAgent> findByAreaOfOperations(String area);
}
