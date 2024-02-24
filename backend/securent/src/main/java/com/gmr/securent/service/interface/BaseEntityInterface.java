package com.gmr.securent.services.interface;

import com.gmr.securent.models.BaseEntity;
/**
 * Interface which acts as a service for BaseEntity class
 */
public interface BaseEntity extends CrudService<BaseEntity, Integer> {
    abstract void register() {}
    abstract void login() {}
    abstract void logout() {}
    abstract void deleteAccount() {}
}
