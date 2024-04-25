package com.gmr.securent.repository;

import java.util.List;
import com.gmr.securent.entity.House;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HouseRepository extends JpaRepository<House, Integer> {
    List<House> findAllByTenantId(Integer tenantId);

    List<House> findAllBylandlordID(Integer landlordID);
}
