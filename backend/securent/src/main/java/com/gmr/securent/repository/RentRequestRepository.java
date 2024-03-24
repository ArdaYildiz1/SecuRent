package com.gmr.securent.repository;

import com.gmr.securent.entity.RentRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RentRequestRepository extends JpaRepository<RentRequest, Integer> {
    List<RentRequest> findAllByTenantID(Integer tenantId);
}
