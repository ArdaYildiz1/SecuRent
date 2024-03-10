package com.gmr.securent.controller;

import com.gmr.securent.entity.Tenant;
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
    public List<Tenant> getAllTenantInstances(){
        return tenantService.getAllTenants();
    }

    @PostMapping
    public Tenant createTenant(@RequestBody Tenant newTenant) {
        return tenantService.saveOneTenant(newTenant);
//        Tenant user = tenantService.saveOneTenant(newTenant);
//        if(user != null) {
//            return new ResponseEntity<>(HttpStatus.CREATED);
//        }
//        else {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
    }

    @GetMapping("/{userId}")
    public Tenant getOneTenant(@PathVariable Integer userId) {
        Tenant tenant = tenantService.getOneTenantById(userId);
        if(tenant == null) {
            throw new NullPointerException("Tenant cannot be null");
        }
        return tenant;
    }

    @PutMapping("/{userId}")
    public ResponseEntity<Void> updateOneTenant(@PathVariable Integer userId, @RequestBody Tenant newTenant) {
        Tenant tenant = tenantService.updateOneTenant(userId, newTenant);
        if(tenant != null)
            return new ResponseEntity<>(HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @DeleteMapping("/{userId}")
    public void deleteOneTenant(@PathVariable Integer userId) {
        tenantService.deleteById(userId);
    }
}