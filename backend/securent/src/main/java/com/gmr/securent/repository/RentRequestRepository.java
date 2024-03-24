package com.gmr.securent.repository;

import com.gmr.securent.entity.RentRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentRequestRepository extends JpaRepository<RentRequest, Integer> {
}
