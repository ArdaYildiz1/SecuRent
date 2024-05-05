package com.gmr.securent.service.interfaces;

import java.util.List;

import com.gmr.securent.entity.AssignedJobs;
import com.gmr.securent.entity.Government;
import com.gmr.securent.entity.House;
import com.gmr.securent.entity.RentRequest;
import com.gmr.securent.entity.RentalContract;

// house and RentalContract should be imported
public interface GovernmentInterface {
    Government getGovernment(Integer userId);

    void deleteById(Integer governmentId);

    Government saveGovernment(Government newGovernment);

    Government updateGovernment(Integer governmentId, Government newGovernment);

    void assignExpert(House house, Integer agentId);

    void monitorContracts();

    void manageDeposits();

    void redistributeDeposits(); // params not added

    String disputeResolution(House house);

    abstract double determinePrice(House house);

    void confirmContract(RentalContract contract);

    public void payDeposit(Integer userId, Double amount);

    List<AssignedJobs> getAllAssignedJobsRequestsForGovernment(Integer governmentID);

    List<AssignedJobs> getNewApproveContractRequestsForGovernment(Integer governmentID);

    List<AssignedJobs> getCurrentApproveContractRequestsForGovernment(Integer governmentID);

    List<AssignedJobs> getOldApproveContractRequestsForGovernment(Integer governmentID);

    List<AssignedJobs> getNewHandleComplaintRequestsForGovernment(Integer governmentID);

    List<AssignedJobs> getCurrentHandleComplaintRequestsForGovernment(Integer governmentID);

    List<AssignedJobs> getOldHandleComplaintRequestsForGovernment(Integer governmentID);

    List<AssignedJobs> getNewChooseDepositSideRequestsForGovernment(Integer governmentID);

    List<AssignedJobs> getCurrentChooseDepositSideRequestsForGovernment(Integer governmentID);

    List<AssignedJobs> getOldChooseDepositSideRequestsForGovernment(Integer governmentID);

    void acceptAssignedJobs(Integer assignedJobID);

    void rejectAssignedJobs(Integer assignedJobID);

}