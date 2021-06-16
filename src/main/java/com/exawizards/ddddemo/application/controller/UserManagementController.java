package com.exawizards.ddddemo.application.controller;

import com.exawizards.ddddemo.application.model.CreateNewUserRequest;
import com.exawizards.ddddemo.application.model.UserManagementResponse;
import com.exawizards.ddddemo.domain.exception.UserManagementException;
import com.exawizards.ddddemo.domain.model.User;
import com.exawizards.ddddemo.domain.service.UserIdGenerator;
import com.exawizards.ddddemo.domain.service.UserManagementService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@org.springframework.web.bind.annotation.RestController
@Slf4j
@RequiredArgsConstructor
public class UserManagementController {

    private final UserIdGenerator userIdGenerator;
    private final UserManagementService userManagementService;

    @PostMapping("/user")
    public ResponseEntity<UserManagementResponse> createUser(
        @RequestBody CreateNewUserRequest request
    ) throws UserManagementException {
        var user = new User(
            userIdGenerator.generateId(),
            request.getName(),
            request.getOrganization()
        );

        userManagementService.createUser(user);

        return new ResponseEntity<>(
            new UserManagementResponse(user.getId()),
            HttpStatus.ACCEPTED
        );
    }
}
