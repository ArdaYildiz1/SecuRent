package com.gmr.securent.service.interfaces;

import com.gmr.securent.entity.BaseEntity;

import java.util.List;

/**
 * Interface which acts as a service for BaseEntity class
 */
public interface BaseEntityInterface {
    List<BaseEntity> getAllBaseEntities();
    BaseEntity saveOneBaseEntity(BaseEntity newBaseEntity);
    BaseEntity getOneBaseEntityById(Integer userId);
    BaseEntity updateOneBaseEntity(Integer userId, BaseEntity newBaseEntity);
    void deleteById(Integer userId);
}
 