package com.gmr.securent.repository;

import com.gmr.securent.entity.RealEstateAgent;
import com.gmr.securent.entity.RealEstateAgentOperations;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RealEstateAgentRepository extends JpaRepository<RealEstateAgent, Integer> {
}
