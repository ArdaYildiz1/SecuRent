package com.gmr.securent.repository;

import com.gmr.securent.entity.House;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HouseRepository extends JpaRepository<House, Integer> {
    List<House> findAllByTenantId(Integer tenantId);

}
