package com.gmr.securent.repository;

import com.gmr.securent.entity.Government;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TenantRepository extends JpaRepository<Government, Integer> {
}
