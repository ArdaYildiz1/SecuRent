package com.gmr.securent.repository;

import com.gmr.securent.entity.Contract;
import com.gmr.securent.entity.House;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractRepository extends JpaRepository<Contract, Long> {
}
