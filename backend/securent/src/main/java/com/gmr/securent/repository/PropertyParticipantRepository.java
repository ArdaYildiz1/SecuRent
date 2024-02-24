package com.gmr.securent.repository;

import com.gmr.securent.model.BaseEntity;
import com.gmr.securent.model.HouseProperties;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyParticipantRepository extends CrudRepository<BaseEntity, Integer> {
}