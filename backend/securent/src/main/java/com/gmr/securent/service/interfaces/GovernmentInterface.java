package com.gmr.securent.service.interfaces;

import com.gmr.securent.model.House;

// house and RentalContract should be imported
public interface GovernmentInterface {
    
    public void assignExpert(House house);

    public void monitorContracts();

    public void manageDeposits();

    public void confirmContracts( RentalContract contract);

    public String disputeResolution(House house);
    abstract double determinePrice (House house );
}