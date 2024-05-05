package com.gmr.securent.repository;

import com.gmr.securent.entity.AssignedJobs;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GovernmentOperationsRepository extends JpaRepository<AssignedJobs, Integer> {
    List<AssignedJobs> findAllByTenantID(Integer tenantId);

    List<AssignedJobs> findAllByGovernmentID(Integer governmentId);

}
