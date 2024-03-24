package com.gmr.securent.service;

import java.util.List;
import java.util.Optional;

import org.springframework.dao.EmptyResultDataAccessException;

import com.gmr.securent.entity.Admin;
import com.gmr.securent.repository.AdminRepository;
import com.gmr.securent.repository.TenantRepository;
import com.gmr.securent.service.interfaces.AdminInterface;

public class AdminService implements AdminInterface {
    AdminRepository adminRepository;

    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Override
    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    @Override
    public Admin saveOneAdmin(Admin newAdmin) {
        return adminRepository.save(newAdmin);
    }

    @Override
    public Admin getOneAdminById(Integer adminId) {
        return adminRepository.findById(adminId).orElse(null);
    }

    @Override
    public Admin updateOneAdmin(Integer adminId, Admin newAdmin) {
        Optional<Admin> admin = adminRepository.findById(adminId);
        if (admin.isPresent()) {
            Admin foundAdmin = admin.get();
            foundAdmin.setFirstName(newAdmin.getFirstName());
            foundAdmin.setLastName(newAdmin.getLastName());
            foundAdmin.setPassword(newAdmin.getPassword());
            foundAdmin.setEmailAddress(newAdmin.getEmailAddress());
            foundAdmin.setPhoneNo(newAdmin.getPhoneNo());
            foundAdmin.setTck(newAdmin.getTck());
            return foundAdmin;
        }
        else {
            throw new RuntimeException("Admin not found with ID: " + adminId);
        }
    }

    @Override
    public void deleteById(Integer adminId) {
        try {
            adminRepository.deleteById(adminId);
        } catch (EmptyResultDataAccessException e) {
            System.err.println("Admin " + adminId + " doesn't exist");
        }
    }

    @Override
    public void openGovernmentAccount() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void listUsers() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void updateUsers() {
        // TODO Auto-generated method stub
        
    }
}
