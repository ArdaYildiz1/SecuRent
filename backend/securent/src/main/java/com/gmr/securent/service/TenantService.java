package com.gmr.securent.service;

import com.gmr.securent.entity.Tenant;
import com.gmr.securent.repository.TenantRepository;
import com.gmr.securent.service.interfaces.TenantInterface;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TenantService implements TenantInterface {
    TenantRepository tenantRepository;
    public TenantService(TenantRepository tenantRepository) {
        this.tenantRepository = tenantRepository;
    }

    @Override
    public List<Tenant> getAllTenants() {
        return tenantRepository.findAll();
    }
    @Override
    public Tenant saveOneTenant(Tenant newTenant) {
        System.out.println("TENANT INFO STARTS HERE");
        System.out.println(newTenant.toString());
        System.out.println(newTenant.getEntityId());
        return tenantRepository.save(newTenant);
    }
    @Override
    public Tenant getOneTenantById(Integer userId) {
        return tenantRepository.findById(userId).orElse(null);
    }
    @Override
    public Tenant updateOneTenant(Integer userId, Tenant newTenant) {
        Optional<Tenant> baseEntity = tenantRepository.findById(userId);
        if(baseEntity.isPresent()) {
            Tenant foundTenant = baseEntity.get();
            foundTenant.setFirstName(newTenant.getFirstName());
            foundTenant.setLastName(newTenant.getLastName());
            foundTenant.setPassword(newTenant.getPassword());
            tenantRepository.save(foundTenant);
            return foundTenant;
        } else {
            return null;
        }
    }
    @Override
    public void deleteById(Integer userId) {
        try {
            tenantRepository.deleteById(userId);
        } catch(EmptyResultDataAccessException e) { //user zaten yok, db'den empty result gelmiş
            System.out.println("Tenant "+userId+" doesn't exist"); //istersek loglayabiliriz
        }
    }
}