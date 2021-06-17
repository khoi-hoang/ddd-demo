package com.exawizards.ddddemo.domain.service;

import com.exawizards.ddddemo.domain.exception.UserManagementException;
import com.exawizards.ddddemo.domain.exception.UserRepositoryException;
import com.exawizards.ddddemo.domain.model.User;
import com.exawizards.ddddemo.domain.repository.UserRepository;
import com.exawizards.ddddemo.infrastructure.repository.RedisUserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserManagementServiceImpl implements UserManagementService {
    private final UserRepository userRepository;
    private final AuthenticationService authenticationService;

    @Override
    public void createUser(User user) throws UserManagementException {
        if (!authenticationService.isAdmin()) {
            throw new UserManagementException("Insufficient permissions to create users.", null);
        }

        // Validate user object before saving user
        if (user == null) {
            throw new UserManagementException("Cannot create null user", null); 
        }

        try {
            userRepository.saveUser(user);
        } catch (UserRepositoryException e) {
            throw new UserManagementException("Could not persist user in the DB", e);
        }
    }

    @Override
    public void deleteUser(User user) throws UserManagementException {
        if (!authenticationService.isAdmin()) {
            throw new UserManagementException("Insufficient permissions to drop users.", null);
        }

        try {
            userRepository.dropUser(user);
        } catch (UserRepositoryException e) {
            throw new UserManagementException("Could not delete user in the DB", e);
        }
    }
}
