package com.gmr.securent.service;

import com.gmr.securent.entity.BaseEntity;
import com.gmr.securent.repository.BaseEntityRepository;
import com.gmr.securent.service.interfaces.BaseEntityInterface;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BaseEntityService implements BaseEntityInterface {
    BaseEntityRepository baseEntityRepository;
    public BaseEntityService(BaseEntityRepository baseEntityRepository) {
        this.baseEntityRepository = baseEntityRepository;
    }

    @Override
    public List<BaseEntity> getAllBaseEntities() {
        return baseEntityRepository.findAll();
    }
    @Override
    public BaseEntity saveOneBaseEntity(BaseEntity newBaseEntity) {
        return baseEntityRepository.save(newBaseEntity);
    }
    @Override
    public BaseEntity getOneBaseEntityById(Integer userId) {
        return baseEntityRepository.findById(userId).orElse(null);
    }
    @Override
    public BaseEntity updateOneBaseEntity(Integer userId, BaseEntity newBaseEntity) {
        Optional<BaseEntity> baseEntity = baseEntityRepository.findById(userId);
        if(baseEntity.isPresent()) {
            BaseEntity foundBaseEntity = baseEntity.get();
            foundBaseEntity.setFirstName(newBaseEntity.getFirstName());
            foundBaseEntity.setLastName(newBaseEntity.getLastName());
            foundBaseEntity.setPassword(newBaseEntity.getPassword());
            baseEntityRepository.save(foundBaseEntity);
            return foundBaseEntity;
        } else {
            return null;
        }
    }
    @Override
    public void deleteById(Integer userId) {
        try {
            baseEntityRepository.deleteById(userId);
        } catch(EmptyResultDataAccessException e) { //user zaten yok, db'den empty result gelmiş
            System.out.println("BaseEntity "+userId+" doesn't exist"); //istersek loglayabiliriz
        }
    }
}
