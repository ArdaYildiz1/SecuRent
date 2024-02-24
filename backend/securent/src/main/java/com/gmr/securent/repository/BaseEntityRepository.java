package com.gmr.securent.repository;

import com.gmr.securent.model.BaseEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BaseEntityRepository extends CrudRepository<BaseEntity, Integer> {
}