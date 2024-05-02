package com.gmr.securent.entity;

import com.gmr.securent.entity.enums.Role;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "registered_user")
public class RegisteredUser {
    @Id
    @Column(name = "entity_id")
    private Integer entityId;

    @Column(name = "email_address")
    private String emailAddress;

    @Column(name = "password")
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Role role;
}
