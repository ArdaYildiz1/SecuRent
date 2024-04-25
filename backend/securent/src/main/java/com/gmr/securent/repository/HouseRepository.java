package com.gmr.securent.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gmr.securent.entity.House;

public interface HouseRepository extends JpaRepository<House, Integer> {
    List<House> findAllBylandlordID(Integer landlordID);
}
