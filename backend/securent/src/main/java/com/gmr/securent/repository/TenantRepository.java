package com.gmr.securent.repository;

import com.gmr.securent.model.Tenant;
import org.springframework.data.repository.CrudRepository;

public interface TenantRepository extends CrudRepository<Tenant, Integer> {
}
