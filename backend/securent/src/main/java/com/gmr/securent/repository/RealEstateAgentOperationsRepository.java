package com.gmr.securent.repository;

import com.gmr.securent.entity.RealEstateAgentOperations;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RealEstateAgentOperationsRepository extends JpaRepository<RealEstateAgentOperations, Integer> {
    List<RealEstateAgentOperations> findAllByTenantID(Integer tenantId);
}
