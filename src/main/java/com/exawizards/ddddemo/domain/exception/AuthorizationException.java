package com.exawizards.ddddemo.domain.exception;

public class AuthorizationException extends Exception {

    public AuthorizationException(String message, Throwable cause) {
        super(message, cause);
    }
}
