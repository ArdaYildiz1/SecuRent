package com.gmr.securent.controller;

import com.gmr.securent.entity.RealEstateAgentOperations;
import com.gmr.securent.entity.RentRequest;
import com.gmr.securent.entity.Tenant;
import com.gmr.securent.exceptions.UserNotFoundException;
import com.gmr.securent.responses.TenantResponse;
import com.gmr.securent.service.TenantService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tenants")
public class TenantController {

    private TenantService tenantService;

    public TenantController(TenantService tenantService) {
        this.tenantService = tenantService;
    }

    @GetMapping
    public List<TenantResponse> getAllTenantEntities(){
        return tenantService.getAllTenants().stream().map(u -> new TenantResponse(u)).toList();
    }

    @PostMapping
    public ResponseEntity<Void> createNewTenant(@RequestBody Tenant newTenant) {
        Tenant tenant = tenantService.saveOneTenant(newTenant);
        if(tenant != null)
            return new ResponseEntity<>(HttpStatus.CREATED);
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/{tenantId}")
    public TenantResponse getOneTenant(@PathVariable Integer tenantId) {
        Tenant tenant = tenantService.getOneTenantById(tenantId);
        if(tenant == null) {
            throw new UserNotFoundException();
        }
        return new TenantResponse(tenant);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<Void> updateOneTenant(@PathVariable Integer userId, @RequestBody Tenant newTenant) {
        Tenant tenant = tenantService.updateOneTenant(userId, newTenant);
        if(tenant != null)
            return new ResponseEntity<>(HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

    }
    @DeleteMapping("/{tenantId}")
    public void deleteOneUser(@PathVariable Integer tenantId) {
        tenantService.deleteById(tenantId);
    }
    @PostMapping("/{tenantId}/pay-deposit")
    public ResponseEntity<Void> payDeposit(@PathVariable Integer tenantId, @RequestParam Double amount) {
        tenantService.payDeposit(tenantId, amount);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/{tenantId}/renting-requests")
    public ResponseEntity<List<RentRequest>> getAllRentingRequestsForTenant(@PathVariable Integer tenantId) {
        List<RentRequest> rentingRequests = tenantService.getAllRentingRequestsForTenant(tenantId);
        return new ResponseEntity<>(rentingRequests, HttpStatus.OK);
    }
    @PostMapping("/{tenantId}/send-renting-request")
    public ResponseEntity<Void> sendRentingRequestToLandlord(@PathVariable Integer tenantId, @RequestBody RentRequest rentRequest) {
        tenantService.sendRentingRequestToLandlord(tenantId, rentRequest.getLandlordID(), rentRequest.getHouseID());
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/{tenantId}/cancel-renting-request/{rentRequestId}")
    public ResponseEntity<Void> cancelRentingRequestToLandlord(@PathVariable Integer rentRequestId) {
        tenantService.cancelRentingRequestToLandlord(rentRequestId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/{tenantId}/real-estate-agent-operations")
    public ResponseEntity<List<RealEstateAgentOperations>> getAllRealEstateAgentOperationsForTenant(@PathVariable Integer tenantId) {
        List<RealEstateAgentOperations> rentalServices = tenantService.getAllRealEstateAgentOperationsForTenant(tenantId);
        return new ResponseEntity<>(rentalServices, HttpStatus.OK);
    }
    @PostMapping("/{tenantId}/send-real-estate-agent-operation-request")
    public ResponseEntity<Void> sendRealEstateAgentOperationsRequest(@PathVariable Integer tenantId,
                                                                     @RequestBody RealEstateAgentOperations rentalService) {
        tenantService.sendRealEstateAgentOperationRequest(tenantId,
                rentalService.getRealEstateAgentID(),
                rentalService.getHouseID(),
                rentalService.getServiceType());
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/{tenantId}/cancel-real-estate-agent-operation-request/{serviceId}")
    public ResponseEntity<Void> cancelRentalServiceRequest(@PathVariable Integer serviceId) {
        tenantService.cancelRealEstateAgentOperationRequest(serviceId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PostMapping("/{tenantId}/rate-real-estate-agent/{agentId}")
    public ResponseEntity<Void> rateRealEstateAgent(@PathVariable Integer agentId,
                                                    @RequestParam Double rating) {
        tenantService.rateRealEstateAgent(agentId, rating);
        return new ResponseEntity<>(HttpStatus.OK);
    }
//    @GetMapping("/houses")
//    public List<House> getHouses(
//            @RequestParam(required = false) String address,
//            @RequestParam(required = false) LocalDate adDate,
//            @RequestParam(required = false) Double areaGross,
//            @RequestParam(required = false) Double areaNet,
//            @RequestParam(required = false) Double areaOpenSpace,
//            @RequestParam(required = false) Integer numberOfRooms,
//            @RequestParam(required = false) Integer buildingAge,
//            @RequestParam(required = false) Integer flatNumber,
//            @RequestParam(required = false) Heating heating,
//            @RequestParam(required = false) Integer numberOfBathrooms,
//            @RequestParam(required = false) Boolean balconyIsPresent,
//            @RequestParam(required = false) Boolean furnitureIsPresent,
//            @RequestParam(required = false) Boolean insideASite,
//            @RequestParam(required = false) String siteName,
//            @RequestParam(required = false) Double currentAmount) {
//
//        return tenantService.getHouses(
//                address,
//                adDate,
//                areaGross,
//                areaNet,
//                areaOpenSpace,
//                numberOfRooms,
//                buildingAge,
//                flatNumber,
//                heating,
//                numberOfBathrooms,
//                balconyIsPresent,
//                furnitureIsPresent,
//                insideASite,
//                siteName,
//                currentAmount);
//    }
    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    private void handleUserNotFound() {}
}
