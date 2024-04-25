package com.gmr.securent.responses;

import com.gmr.securent.entity.Landlord;
import lombok.Data;

@Data
public class LandlordResponse {
    Integer id;
    String firstName;
    String lastName;

    public LandlordResponse(Landlord landlord) {
        this.id = landlord.getEntityID();
        this.firstName = landlord.getFirstName();
        this.lastName = landlord.getLastName();
    }
}
