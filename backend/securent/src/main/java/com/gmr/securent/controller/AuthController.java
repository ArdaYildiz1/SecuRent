package com.gmr.securent.controller;

import com.gmr.securent.entity.Landlord;
import com.gmr.securent.entity.RealEstateAgent;
import com.gmr.securent.entity.Tenant;
import com.gmr.securent.entity.enums.Role;
import com.gmr.securent.payload.request.LoginRequest;
import com.gmr.securent.payload.request.SignUpRequest;
import com.gmr.securent.repository.LandlordRepository;
import com.gmr.securent.repository.RealEstateAgentRepository;
import com.gmr.securent.repository.TenantRepository;
import com.gmr.securent.service.TenantService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:3000")
public class AuthController {
    private TenantRepository tenantRepository;
    private LandlordRepository landlordRepository;
    private RealEstateAgentRepository realEstateAgentRepository;
    private TenantService tenantService;
    public AuthController(TenantRepository tenantRepository,
                          LandlordRepository landlordRepository,
                          RealEstateAgentRepository realEstateAgentRepository,
                          TenantService tenantService) {
        this.tenantRepository = tenantRepository;
        this.landlordRepository = landlordRepository;
        this.realEstateAgentRepository = realEstateAgentRepository;
        this.tenantService = tenantService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        Tenant existingTenant = tenantRepository.findByEmailAddress(request.getEmail());
        Landlord existingLandlord = landlordRepository.findByEmailAddress(request.getEmail());
        RealEstateAgent existingRealEstateAgent = realEstateAgentRepository.findByEmailAddress(request.getEmail());
        if ((existingTenant != null && existingTenant.getPassword().equals(request.getPassword()))
                || (existingLandlord != null && existingLandlord.getPassword().equals(request.getPassword()))
                || (existingRealEstateAgent != null && existingRealEstateAgent.getPassword().equals(request.getPassword()))) {

                if (existingTenant != null) {
                    Tenant tenant = tenantService.getOneTenantByEmailAndPassword(request.getEmail(), request.getPassword());
                    return ResponseEntity.ok(tenant);
                }
                if (existingLandlord != null) {
                    //                    Landlord landlord = landlordService.getOneLandlordByEmailAndPassword(request.getEmail(), request.getPassword());
                    return ResponseEntity.ok("implement landlord");
                }
                if (existingRealEstateAgent != null) {
                    //                    RealEstateAgent agent = agentService.getOneAgentByEmailAndPassword(request.getEmail(), request.getPassword());
                    return ResponseEntity.ok("implement real estate agent");
                }
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
        }
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody SignUpRequest request) {
        // Check if the email address is already registered
        try {
            Tenant existingTenant = tenantRepository.findByEmailAddress(request.getEmailAddress());
            Landlord existingLandlord = landlordRepository.findByEmailAddress(request.getEmailAddress());
            RealEstateAgent existingRealEstateAgent = realEstateAgentRepository.findByEmailAddress(request.getEmailAddress());

            if (existingTenant != null || existingLandlord != null || existingRealEstateAgent != null) {
                return ResponseEntity.badRequest().body("Email address is already registered");
            }

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