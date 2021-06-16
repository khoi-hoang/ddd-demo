package com.exawizards.ddddemo.application.controller;

import com.exawizards.ddddemo.application.model.ExceptionResponse;
import com.exawizards.ddddemo.domain.exception.UserManagementException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class ExceptionController {
    @ExceptionHandler({UserManagementException.class})
    public ResponseEntity<ExceptionResponse> handleUserManagementException(
        UserManagementException e
    ) {
        log.error("User management exception happened", e);
        return new ResponseEntity<>(
            new ExceptionResponse("could not save user"),
            HttpStatus.INTERNAL_SERVER_ERROR
        );
    }
}
