package com.gmr.securent.repository;

import com.gmr.securent.entity.Government;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GovernmentRepository extends JpaRepository<Government, Integer> {
    Government findByEmailAddressAndPassword(String emailAddress, String password);

    Government findByEmailAddress(String email);
}
