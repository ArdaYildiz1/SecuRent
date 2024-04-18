package com.gmr.securent.responses;

import com.gmr.securent.entity.Tenant;
import lombok.Data;

@Data
public class TenantResponse {
	
	Integer id;
	String firstName;
	String lastName;

	public TenantResponse(Tenant tenant) {
		this.id = tenant.getEntityId();
		this.firstName = tenant.getFirstName();
		this.lastName= tenant.getLastName();
	} 
}
