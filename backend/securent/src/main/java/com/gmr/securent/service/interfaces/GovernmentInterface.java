package com.gmr.securent.service.interfaces;

import com.gmr.securent.model.House;
import com.gmr.securent.model.RentalContract;

// house and RentalContract should be imported
public interface GovernmentInterface {
    
    public void assignExpert(House house);

    public void monitorContracts();

    public void manageDeposits();
    public void redistributeDeposits(); // params not added

    public String disputeResolution(House house);
    abstract double determinePrice (House house );

    void confirmContract(RentalContract contract);
}