package com.gmr.securent.service;

import com.gmr.securent.entity.House;
import com.gmr.securent.repository.HouseRepository;
import com.gmr.securent.service.interfaces.HouseInterface;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HouseService implements HouseInterface {

    // Inject necessary dependencies
    HouseRepository houseRepository;
    EntityManager entityManager;

    public HouseService(HouseRepository houseRepository, EntityManager entityManager) {
        this.houseRepository = houseRepository;
        this.entityManager = entityManager;
    }

    @Override
    public List<House> getAllHouses() {
        return houseRepository.findAll();
    }
    public List<House> filterHouses(String address, Integer numberOfRooms, Integer flatNumber) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<House> criteriaQuery = criteriaBuilder.createQuery(House.class);
        Root<House> root = criteriaQuery.from(House.class);

        List<Predicate> predicates = new ArrayList<>();

        if (address != null) {
            predicates.add(criteriaBuilder.equal(root.get("address"), address));
        }
        if (numberOfRooms != null) {
            predicates.add(criteriaBuilder.equal(root.get("numberOfRooms"), numberOfRooms));
        }
        if (flatNumber != null) {
            predicates.add(criteriaBuilder.equal(root.get("flatNumber"), flatNumber));
        }

        criteriaQuery.where(predicates.toArray(new Predicate[0]));

        return entityManager.createQuery(criteriaQuery).getResultList();
    }
    @Override
    public House saveOneHouse(House newHouse) {
        return houseRepository.save(newHouse);
    }
    @Override
    public House getOneHouseById(Integer userId) {
        return houseRepository.findById(userId).orElse(null);
    }
    @Override
    public House updateOneHouse(Integer houseId, House newHouse) {
        Optional<House> house = houseRepository.findById(houseId);
        if (house.isPresent()) {
            House foundHouse = house.get();
            foundHouse.setAddress(newHouse.getAddress());
            foundHouse.setAdDate(newHouse.getAdDate());
            foundHouse.setAreaGross(newHouse.getAreaGross());
            foundHouse.setAreaNet(newHouse.getAreaNet());
            foundHouse.setAreaOpenSpace(newHouse.getAreaOpenSpace());
            foundHouse.setNumberOfRooms(newHouse.getNumberOfRooms());
            foundHouse.setBuildingAge(newHouse.getBuildingAge());
            foundHouse.setFlatNumber(newHouse.getFlatNumber());
            foundHouse.setHeating(newHouse.getHeating());
            foundHouse.setNumberOfBathrooms(newHouse.getNumberOfBathrooms());
            foundHouse.setBalconyIsPresent(newHouse.isBalconyIsPresent());
            foundHouse.setFurnitureIsPresent(newHouse.isFurnitureIsPresent());
            foundHouse.setInsideASite(newHouse.isInsideASite());
            foundHouse.setSiteName(newHouse.getSiteName());
            foundHouse.setCurrentAmount(newHouse.getCurrentAmount());
            return foundHouse;
        }
        else {
            throw new RuntimeException("House not found with ID: " + houseId);
        }
    }
    @Override
    public void deleteById(Integer houseId) {
        try {
            houseRepository.deleteById(houseId);
        } catch(EmptyResultDataAccessException e) {
            System.out.println("House "+ houseId +" doesn't exist");
        }
    }
}