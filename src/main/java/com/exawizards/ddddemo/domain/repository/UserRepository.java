package com.exawizards.ddddemo.domain.repository;

import com.exawizards.ddddemo.domain.exception.UserRepositoryException;
import com.exawizards.ddddemo.domain.model.User;

/**
 * Persists Users in the DB.
 */
public interface UserRepository {
    void saveUser(User user) throws UserRepositoryException;
    void dropUser(User user) throws UserRepositoryException;
}
