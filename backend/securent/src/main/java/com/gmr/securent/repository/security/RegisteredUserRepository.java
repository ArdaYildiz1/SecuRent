package com.gmr.securent.repository.security;

import com.gmr.securent.entity.RegisteredUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegisteredUserRepository extends JpaRepository<RegisteredUser, Integer> {
    RegisteredUser findByEmailAddress(String email);
}
