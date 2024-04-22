package com.gmr.securent.service.interfaces;

import com.gmr.securent.entity.House;

import java.util.List;


public interface HouseInterface {
    List<House> getAllHouses();
    House saveOneHouse(House newHouse);
    House getOneHouseById(Integer houseId);
    House updateOneHouse(Integer houseId, House newHouse);
    void deleteById(Integer houseId);
}
