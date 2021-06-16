package com.exawizards.ddddemo.domain.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.exawizards.ddddemo.domain.exception.UserManagementException;
import com.exawizards.ddddemo.domain.exception.UserRepositoryException;
import com.exawizards.ddddemo.domain.model.User;
import com.exawizards.ddddemo.domain.repository.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

class UserManagementServiceImplTest {

    @Mock
    private UserRepository mockedUserRepository;

    @Mock
    private AuthenticationService mockedAuthenticationService;

    // Important, main actor!
    private UserManagementService underTest;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        underTest = new UserManagementServiceImpl(
            mockedUserRepository,
            mockedAuthenticationService
        );
    }

    // Method_Result_How
    @Test
    void createUser_Failed_NotAdmin() throws UserRepositoryException {
        when(mockedAuthenticationService.isAdmin()).thenReturn(false);
        // mock userRepository

        User user = new User("myId", "khoi", "");

        Exception e = assertThrows(UserManagementException.class, () -> {
            underTest.createUser(user);
        });
        assertEquals("Insufficient permissions to create users.", e.getMessage(), "Message is wrong!");
    }

    @Test
    void createUser_Successful() throws UserRepositoryException, UserManagementException {
        when(mockedAuthenticationService.isAdmin()).thenReturn(true);
        User user = new User("abc", "khoi", "exa");
        underTest.createUser(user);
        verify(mockedUserRepository).saveUser(new User("abc", "khoi", "exa"));
    }

    @Test
    void deleteUser() {
    }
}
