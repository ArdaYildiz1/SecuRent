package com.gmr.securent.payload.request;

import com.gmr.securent.entity.enums.Role;
import lombok.Data;

@Data
public class SignUpRequest {
        private String firstName;

        private String lastName;

        private String password;

        private String emailAddress;

        private String phoneNo;

        private Role role;

        private long tck;
}
