package com.gmr.securent.controller;

import com.gmr.securent.entity.*;
import com.gmr.securent.exceptions.UserNotFoundException;
import com.gmr.securent.service.GovernmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/landlords")
public class GovernmentController {

    private GovernmentService governmentService;

    public GovernmentController(GovernmentService governmentService) {
        this.governmentService = governmentService;
    }

    @GetMapping
    public List<Government> getAllLandlordEntities() {
        return governmentService.getAllGovernments();
    }

    @PostMapping
    public ResponseEntity<Void> createNewGovernment(@RequestBody Government newGovernment) {
        Government government = governmentService.saveGovernment(newGovernment);
        if (government != null) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/{governmentID}")
    public Government getOneGovernment(@PathVariable Integer governmentID) {
        Government government = governmentService.getGovernment(governmentID);
        if (government == null) {
            throw new UserNotFoundException();
        }
        return government;
    }

    @PutMapping("/{governmentID}")
    public ResponseEntity<Void> updateOneGovernment(@PathVariable Integer governmentID,
            @RequestBody Government newGovernment) {
        Government government = governmentService.updateGovernment(governmentID, newGovernment);
        if (government != null) {
            System.out.println("GOVERNMENT TEST:" + government.toString());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @DeleteMapping("/{governmentID}")
    public void deleteOneGovernment(@PathVariable Integer governmentID) {
        governmentService.deleteById(governmentID);
    }

    @GetMapping("/{governmentID}/assigned-jobs")
    public ResponseEntity<List<AssignedJobs>> getAllAssignedJobsForGovernment(@PathVariable Integer governmentID) {
        List<AssignedJobs> AssignedJobs = governmentService.getAllAssignedJobsRequestsForGovernment(governmentID);
        return new ResponseEntity<>(AssignedJobs, HttpStatus.OK);
    }

    @PutMapping("/{governmentID}/assigned-jobs/{serviceId}/confirm")
    public void confirmRentingRequest(@PathVariable Integer jobId) {
        governmentService.acceptAssignedJobs(jobId);
    }

    @PutMapping("/{governmentID}/renting-requests/{serviceId}/reject")
    public void rejectRentalService(@PathVariable Integer serviceId) {
        governmentService.rejectAssignedJobs(serviceId);
    }

}
