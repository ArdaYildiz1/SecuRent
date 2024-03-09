package com.gmr.securent.service;

import com.gmr.securent.entity.HouseProperties;
import com.gmr.securent.service.interfaces.PropertyParticipantInterface;
import org.springframework.stereotype.Service;

@Service
public class PropertyParticipantService implements PropertyParticipantInterface {
    @Override
    public void searchHouse(HouseProperties houseProperties) {
        // TODO: Will be completed when the HouseRepository is created
        //houseProperties.findByHouseID()
    }
}
