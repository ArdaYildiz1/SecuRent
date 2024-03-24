package com.gmr.securent.service.interfaces;

import java.util.List;

import com.gmr.securent.entity.Admin;

public interface AdminInterface {
    List<Admin> getAllAdmins();
    Admin saveOneAdmin(Admin newAdmin);
    Admin getOneAdminById(Integer adminId);
    Admin updateOneAdmin(Integer adminId, Admin newAdmin);
    void deleteById(Integer adminId);
    void openGovernmentAccount();
    void listUsers();
    void updateUsers();
}
