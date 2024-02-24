package com.gmr.securent.service;

import com.gmr.securent.repository.BaseEntityRepository;
import com.gmr.securent.service.interfaces.BaseEntityInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BaseEntityService implements BaseEntityInterface {

    private final BaseEntityRepository baseEntityRepository;

    @Autowired
    public BaseEntityService(BaseEntityRepository baseEntityRepository) {
        this.baseEntityRepository = baseEntityRepository;
    }

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
