package com.gmr.securent.controller;

import com.gmr.securent.entity.*;
import com.gmr.securent.entity.enums.Role;
import com.gmr.securent.payload.request.LoginRequest;
import com.gmr.securent.payload.request.SignUpRequest;
import com.gmr.securent.repository.RegisteredUserRepository;
import com.gmr.securent.service.TenantService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:3000")
public class AuthController {
    private RegisteredUserRepository registeredUserRepository;
    private TenantService tenantService;
    public AuthController(RegisteredUserRepository registeredUserRepository,
                          TenantService tenantService) {
        this.registeredUserRepository = registeredUserRepository;
        this.tenantService = tenantService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        RegisteredUser registeredUser = registeredUserRepository.findByEmailAddress(request.getEmail());
        if (registeredUser != null && registeredUser.getPassword().equals(request.getPassword())) {
            switch (registeredUser.getRole()) {
                case TENANT:
                    Tenant tenant = tenantService.getOneTenantByEmailAndPassword(request.getEmail(), request.getPassword());
                    return ResponseEntity.ok(tenant);
                case LANDLORD:
//                    Landlord landlord = landlordService.getOneLandlordByEmailAndPassword(request.getEmail(), request.getPassword());
//                    return ResponseEntity.ok(landlord);
                case REAL_ESTATE_AGENT:
//                    RealEstateAgent agent = agentService.getOneAgentByEmailAndPassword(request.getEmail(), request.getPassword());
//                    return ResponseEntity.ok(agent);
                case GOVERNMENT:
//                    Government government = governmentService.getOneGovernmentByEmailAndPassword(request.getEmail(), request.getPassword());
//                    return ResponseEntity.ok(government);
                case ADMIN:
//                    Admin admin = adminService.getOneAdminByEmailAndPassword(request.getEmail(), request.getPassword());
//                    return ResponseEntity.ok(admin);
                default:
                    return ResponseEntity.ok("Role not supported");
            }
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
        }
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody SignUpRequest request) {
        // Check if the email address is already registered
        try {
            RegisteredUser existingUser = registeredUserRepository.findByEmailAddress(request.getEmailAddress());
            if (existingUser != null) {
                return ResponseEntity.badRequest().body("Email address is already registered");
            }
            // Create a new RegisteredUser object
            RegisteredUser user = new RegisteredUser();
            user.setEmailAddress(request.getEmailAddress());
            user.setPassword(request.getPassword());
            user.setRole(request.getRole());
            registeredUserRepository.save(user);

            // Decide the role of the new registered user
            switch (request.getRole()) {
                case TENANT:
                    Tenant tenant = new Tenant();
                    tenant.setFirstName(request.getFirstName());
                    tenant.setLastName(request.getLastName());
                    tenant.setPassword(request.getPassword());
                    tenant.setEmailAddress(request.getEmailAddress());
                    tenant.setPhoneNo(request.getPhoneNo());
                    tenant.setRole(Role.TENANT);
                    tenant.setTck(request.getTck());
                    tenantService.saveOneTenant(tenant);
                    return ResponseEntity.ok(tenant);
                case LANDLORD:
                case REAL_ESTATE_AGENT:
                case GOVERNMENT:
                case ADMIN:
                default:
                    return ResponseEntity.ok("Role not supported");
            }
        } catch (Exception e) {
            // Handle the exception, such as logging or returning a specific error message
            return ResponseEntity.badRequest().body("Invalid email address");
        }

    }
}