package com.gmr.securent.repository;

import com.gmr.securent.entity.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TenantRepository extends JpaRepository<Tenant, Integer> {
    Tenant findByEmailAddressAndPassword(String emailAddress, String password);
}
