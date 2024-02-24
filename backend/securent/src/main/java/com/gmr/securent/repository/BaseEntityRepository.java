package com.gmr.securent.repository;

import com.gmr.securent.model.BaseEntity;
import org.springframework.data.repository.CrudRepository;

public interface BaseEntityRepository extends CrudRepository<Admin, Long> {
}
