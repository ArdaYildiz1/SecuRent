package com.gmr.securent.controller;

import com.gmr.securent.entity.RealEstateAgent;
import com.gmr.securent.entity.RealEstateAgentOperations;
import com.gmr.securent.exceptions.UserNotFoundException;
import com.gmr.securent.service.RealEstateAgentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/real-estate-agents")
@CrossOrigin(origins = "http://localhost:3000")
public class RealEstateAgentController {

    private RealEstateAgentService realEstateAgentService;

    public RealEstateAgentController(RealEstateAgentService realEstateAgentService) {
        this.realEstateAgentService = realEstateAgentService;
    }

    @GetMapping
    public List<RealEstateAgent> getAllRealEstateAgentEntities(){
        return realEstateAgentService.getAllRealEstateAgents();
    }

    @PostMapping
    public ResponseEntity<Void> createNewRealEstateAgent(@RequestBody RealEstateAgent newRealEstateAgent) {
        RealEstateAgent realEstateAgent = realEstateAgentService.saveOneRealEstateAgent(newRealEstateAgent);
        if(realEstateAgent != null)
            return new ResponseEntity<>(HttpStatus.CREATED);
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/{realEstateAgentId}")
    public RealEstateAgent getOneRealEstateAgent(@PathVariable Integer realEstateAgentId) {
        RealEstateAgent realEstateAgent = realEstateAgentService.getOneRealEstateAgentById(realEstateAgentId);
        if(realEstateAgent == null) {
            throw new UserNotFoundException();
        }
        return realEstateAgent;
    }

    @GetMapping("/areaOfOperations")
    public List<RealEstateAgent> getRealEstateAgentsByAreaOfOperations(@RequestBody String areaOfOperations) {
        return realEstateAgentService.getRealEstateAgentForSpecificArea(areaOfOperations);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<Void> updateOneRealEstateAgent(@PathVariable Integer userId, @RequestBody RealEstateAgent newRealEstateAgent) {
        RealEstateAgent realEstateAgent = realEstateAgentService.updateOneRealEstateAgent(userId, newRealEstateAgent);
        if(realEstateAgent != null)
            return new ResponseEntity<>(HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

    }
    @DeleteMapping("/{realEstateAgentId}")
    public void deleteOneUser(@PathVariable Integer realEstateAgentId) {
        realEstateAgentService.deleteById(realEstateAgentId);
    }
    @GetMapping("/{realEstateAgentId}/rental-service-requests")
    public ResponseEntity<List<RealEstateAgentOperations>> getAllRentalServiceRequestsForRealEstateAgent(@PathVariable Integer realEstateAgentId) {
        List<RealEstateAgentOperations> realEstateAgentOperations = realEstateAgentService.getAllRentalServiceRequestsForRealEstateAgent(realEstateAgentId);
        return new ResponseEntity<>(realEstateAgentOperations, HttpStatus.OK);
    }
    @GetMapping("/{realEstateAgentId}/rental-service-requests/rental-service/new")
    public ResponseEntity<List<RealEstateAgentOperations>> getNewRentalServiceRequestsForRealEstateAgent(@PathVariable Integer realEstateAgentId) {
        List<RealEstateAgentOperations> realEstateAgentOperations = realEstateAgentService.getNewRentalServiceRequestsForRealEstateAgent(realEstateAgentId);
        return new ResponseEntity<>(realEstateAgentOperations, HttpStatus.OK);
    }
    @GetMapping("/{realEstateAgentId}/rental-service-requests/rental-service/current")
    public ResponseEntity<List<RealEstateAgentOperations>> getCurrentRentalServiceRequestsForRealEstateAgent(@PathVariable Integer realEstateAgentId) {
        List<RealEstateAgentOperations> realEstateAgentOperations = realEstateAgentService.getCurrentRentalServiceRequestsForRealEstateAgent(realEstateAgentId);
        return new ResponseEntity<>(realEstateAgentOperations, HttpStatus.OK);
    }
    @GetMapping("/{realEstateAgentId}/rental-service-requests/rental-service/old")
    public ResponseEntity<List<RealEstateAgentOperations>> getOldRentalServiceRequestsForRealEstateAgent(@PathVariable Integer realEstateAgentId) {
        List<RealEstateAgentOperations> realEstateAgentOperations = realEstateAgentService.getOldRentalServiceRequestsForRealEstateAgent(realEstateAgentId);
        return new ResponseEntity<>(realEstateAgentOperations, HttpStatus.OK);
    }
    @GetMapping("/{realEstateAgentId}/rental-service-requests/evaluation/new")
    public ResponseEntity<List<RealEstateAgentOperations>> getNewEvaluationRequestsForRealEstateAgent(@PathVariable Integer realEstateAgentId) {
        List<RealEstateAgentOperations> realEstateAgentOperations = realEstateAgentService.getNewEvaluationRequestsForRealEstateAgent(realEstateAgentId);
        return new ResponseEntity<>(realEstateAgentOperations, HttpStatus.OK);
    }
    @GetMapping("/{realEstateAgentId}/rental-service-requests/evaluation/current")
    public ResponseEntity<List<RealEstateAgentOperations>> getCurrentEvaluationRequestsForRealEstateAgent(@PathVariable Integer realEstateAgentId) {
        List<RealEstateAgentOperations> realEstateAgentOperations = realEstateAgentService.getCurrentEvaluationRequestsForRealEstateAgent(realEstateAgentId);
        return new ResponseEntity<>(realEstateAgentOperations, HttpStatus.OK);
    }
    @GetMapping("/{realEstateAgentId}/rental-service-requests/evaluation/old")
    public ResponseEntity<List<RealEstateAgentOperations>> getOldEvaluationRequestsForRealEstateAgent(@PathVariable Integer realEstateAgentId) {
        List<RealEstateAgentOperations> realEstateAgentOperations = realEstateAgentService.getOldEvaluationRequestsForRealEstateAgent(realEstateAgentId);
        return new ResponseEntity<>(realEstateAgentOperations, HttpStatus.OK);
    }
    @PutMapping("/{realEstateAgentId}/rental-service-requests/{rentalServiceId}/accept")
    public void acceptRentalService(@PathVariable Integer realEstateAgentId, @PathVariable Integer rentalServiceId) {
        realEstateAgentService.acceptRentalService(rentalServiceId);
    }
    @PutMapping("/{realEstateAgentId}/rental-service-requests/{rentalServiceId}/reject")
    public void rejectRentalService(@PathVariable Integer realEstateAgentId, @PathVariable Integer rentalServiceId) {
        realEstateAgentService.rejectRentalService(rentalServiceId);
    }
    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    private void handleUserNotFound() {}
}
