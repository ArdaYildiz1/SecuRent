package com.gmr.securent.repository;

import com.gmr.securent.entity.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyParticipantRepository extends JpaRepository<BaseEntity, Integer> {
}