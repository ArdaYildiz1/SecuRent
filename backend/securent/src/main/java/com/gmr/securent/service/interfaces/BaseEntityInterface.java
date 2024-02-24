package com.gmr.securent.service.interfaces;

/**
 * Interface which acts as a service for BaseEntity class
 */
public interface BaseEntityInterface {
    default void register() {}
    void login();
    void logout();
    void deleteAccount();
}
