package com.exawizards.ddddemo.domain.service;

import com.exawizards.ddddemo.domain.exception.UserManagementException;
import com.exawizards.ddddemo.domain.model.User;

public interface UserManagementService {
    void createUser(User user) throws UserManagementException;
    void deleteUser(User user) throws UserManagementException;
}
