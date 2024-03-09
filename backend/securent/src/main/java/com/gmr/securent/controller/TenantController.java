package com.gmr.securent.controller;

import com.gmr.securent.service.TenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tenants")
public class TenantController {
    @Autowired
    private TenantService tenantService;

    @PostMapping("/{tenantId}/pay-deposit")
    public ResponseEntity<Void> payDeposit(@PathVariable("tenantId") int tenantId, @RequestParam("amount") int amount) {
        tenantService.payDeposit(tenantId, amount);
        return ResponseEntity.ok().build();
    }

    // Implement other endpoints similarly...
}
