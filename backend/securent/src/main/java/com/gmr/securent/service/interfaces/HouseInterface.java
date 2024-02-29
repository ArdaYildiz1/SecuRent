package com.gmr.securent.service.interfaces;

import com.gmr.securent.model.HouseProperties;

enum RentalStatus {
    placeholder,
    placeholder2,
    placeholder3;
}

// house properties should be imported
public interface HouseInterface {

    // variables
    public int houseID;
    public HouseProperties houseProperties;
    public RentalStatus rentalStatus = RentalStatus.placeholder;
}