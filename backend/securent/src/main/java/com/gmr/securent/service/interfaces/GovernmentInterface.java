package com.gmr.securent.service.interfaces;

import com.gmr.securent.entity.House;
import com.gmr.securent.entity.RentalContract;
 
// house and RentalContract should be imported
public interface GovernmentInterface {
    
    // basic methods
    public Government getGovernment();
    public Government saveGovernment(Government newGovernment);
    public Government updateGovernment(Integer governmentId, Governemnt newGovernment);
    public void deleteById(Integer governmentId);

    // functionality methods
    public void assignExpert(House house, Integer agentId);

    public void monitorContracts();

    public void manageDeposits();
    public void redistributeDeposits(); // params not added

    public String disputeResolution(House house);
    abstract double determinePrice (House house );

    public void confirmContract(RentalContract contract);
}