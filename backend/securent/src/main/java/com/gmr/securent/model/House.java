package com.gmr.securent.model;

enum RentalStatus {
    placeholder,
    placeholder2,
    placeholder3;
}

@Entity
// house properties should be imported
public class House extends BaseEntity{

    
    // Variables
    public int houseID;
    public HouseProperties houseProperties;
    public RentalStatus rentalStatus = RentalStatus.placeholder;

}
