package com.gmr.securent.controller;

import com.gmr.securent.entity.House;
import com.gmr.securent.exceptions.UserNotFoundException;
import com.gmr.securent.service.HouseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/houses")
@CrossOrigin(origins = "http://securentsys.s3-website.eu-central-1.amazonaws.com")
public class HouseController {

    private HouseService houseService;

    public HouseController(HouseService houseService) {
        this.houseService = houseService;
    }

    @GetMapping
    public List<House> getAllHouseEntities(){
        return houseService.getAllHouses();
    }

    @PostMapping
    public ResponseEntity<Void> createNewHouse(@RequestBody House newHouse) {
        House house = houseService.saveOneHouse(newHouse);
        if(house != null)
            return new ResponseEntity<>(HttpStatus.CREATED);
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/{houseId}")
    public House getOneHouse(@PathVariable Integer houseId) {
        House house = houseService.getOneHouseById(houseId);
        if(house == null) {
            throw new UserNotFoundException();
        }
        return house;
    }

    @PutMapping("/{houseId}")
    public ResponseEntity<Void> updateOneHouse(@PathVariable Integer houseId, @RequestBody House newHouse) {
        House house = houseService.updateOneHouse(houseId, newHouse);
        if(house != null)
            return new ResponseEntity<>(HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

    }
    @DeleteMapping("/{houseId}")
    public void deleteOneUser(@PathVariable Integer houseId) {
        houseService.deleteById(houseId);
    }
    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    private void handleUserNotFound() {}
}
