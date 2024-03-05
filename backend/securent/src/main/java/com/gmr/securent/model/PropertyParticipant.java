package com.gmr.securent.model;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.*;

@Entity
@NoArgsConstructor
@Data
public abstract class PropertyParticipant extends BaseEntity {
    public PropertyParticipant(String firstName,
                               String lastName,
                               String password,
                               String emailAddress,
                               String phoneNo,
                               int TCK,
                               Image profilePhoto) {
        super(firstName, lastName, password, emailAddress, phoneNo, TCK, profilePhoto);
    }

    public PropertyParticipant(String firstName,
                               String lastName,
                               String password,
                               String emailAddress,
                               String phoneNo,
                               int TCK) {
        super(firstName, lastName, password, emailAddress, phoneNo, TCK);
    }
}
