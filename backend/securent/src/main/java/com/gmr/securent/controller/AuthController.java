package com.gmr.securent.controller;

import com.gmr.securent.entity.*;
import com.gmr.securent.entity.enums.Role;
import com.gmr.securent.payload.request.LoginRequest;
import com.gmr.securent.repository.security.RegisteredUserRepository;
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
}