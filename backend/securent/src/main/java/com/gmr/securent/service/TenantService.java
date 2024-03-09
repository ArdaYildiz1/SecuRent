package com.gmr.securent.service;

import com.gmr.securent.entity.Tenant;
import com.gmr.securent.repository.TenantRepository;
import org.springframework.stereotype.Service;

@Service
public class TenantService {
    TenantRepository tenantRepository;

    public void payDeposit(int tenantId, double amount) {
        // Find the tenant by ID
        Tenant tenant = tenantRepository
                .findById(tenantId)
                .orElseThrow(() -> new RuntimeException("Tenant not found"));

        // Update the tenant's deposit payment status
        tenant.setDepositPaid(true);
        tenant.setDepositAmount(amount);

        // Save the updated tenant back to the repository
        tenantRepository.save(tenant);
    }
}
