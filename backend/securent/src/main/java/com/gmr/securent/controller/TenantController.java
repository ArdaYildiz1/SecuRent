package com.gmr.securent.controller;

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

    @DeleteMapping("/{userId}")
    public void deleteOneUser(@PathVariable Integer userId) {
        tenantService.deleteById(userId);
    }

    @PostMapping("/{tenantId}/send-renting-request")
    public ResponseEntity<Void> sendRentingRequestToLandlord(@PathVariable Integer tenantId, @RequestBody RentRequest rentRequest) {
        tenantService.sendRentingRequestToLandlord(tenantId, rentRequest.getLandlordID(), rentRequest.getHouseID(), rentRequest.getServiceType());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/{tenantId}/pay-deposit")
    public ResponseEntity<Void> payDeposit(@PathVariable Integer tenantId, @RequestParam Double amount) {
        tenantService.payDeposit(tenantId, amount);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    private void handleUserNotFound() {}
}
