package com.gmr.securent.repository;

import com.gmr.securent.entity.RentRequest;
import com.gmr.securent.entity.RentalService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RentalServiceRepository extends JpaRepository<RentalService, Integer> {
    List<RentalService> findAllByTenantID(Integer tenantId);
}
