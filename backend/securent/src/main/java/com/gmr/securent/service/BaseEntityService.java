package com.gmr.securent.service;

import com.gmr.securent.service.interface.BaseEntityInterface;
import com.gmr.securent.model.BaseEntity;
import com.gmr.securent.model.Admin;
@Service
/**
 * Class which contains implementations of BaseEntity interface
 */
public class BaseEntityService implements BaseEntityInterface {

    private final BaseEntityRepository baseEntityRepository;

    @Override
    public void register() {
    }

    @Override
    public void login() {
    }

    @Override
    public void logout() {
    }

    @Override
    public void deleteAccount() {
    }
}
