package com.gmr.securent.responses;

import com.gmr.securent.entity.RealEstateAgent;
import com.gmr.securent.entity.Tenant;
import lombok.Data;

@Data
public class RealEstateAgentResponse {

	Integer id;
	String firstName;
	String lastName;

	public RealEstateAgentResponse(RealEstateAgent realEstateAgent) {
		this.id = realEstateAgent.getEntityID();
		this.firstName = realEstateAgent.getFirstName();
		this.lastName= realEstateAgent.getLastName();
	} 
}
