package com.gmr.securent.controller;

import com.gmr.securent.entity.BaseEntity;
import com.gmr.securent.service.BaseEntityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/baseEntities")
public class BaseEntityController {

    private BaseEntityService baseEntityService;

    public BaseEntityController(BaseEntityService baseEntityService) {
        this.baseEntityService = baseEntityService;
    }

    @GetMapping
    public List<BaseEntity> getAllBaseEntities(){
        return baseEntityService.getAllBaseEntities();
    }

    @PostMapping
    public ResponseEntity<Void> createBaseEntity(@RequestBody BaseEntity newBaseEntity) {
        BaseEntity user = baseEntityService.saveOneBaseEntity(newBaseEntity);
        if(user != null)
            return new ResponseEntity<>(HttpStatus.CREATED);
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/{userId}")
    public BaseEntity getOneBaseEntity(@PathVariable Integer userId) {
        BaseEntity user = baseEntityService.getOneBaseEntityById(userId);
        if(user == null) {
            throw new NullPointerException("User cannot be null");
        }
        return user;
    }

    @PutMapping("/{userId}")
    public ResponseEntity<Void> updateOneBaseEntity(@PathVariable Integer userId, @RequestBody BaseEntity newBaseEntity) {
        BaseEntity user = baseEntityService.updateOneBaseEntity(userId, newBaseEntity);
        if(user != null)
            return new ResponseEntity<>(HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @DeleteMapping("/{userId}")
    public void deleteOneBaseEntity(@PathVariable Integer userId) {
        baseEntityService.deleteById(userId);
    }

}
