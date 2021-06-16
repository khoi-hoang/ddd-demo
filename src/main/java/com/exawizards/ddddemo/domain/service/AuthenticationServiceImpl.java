package com.exawizards.ddddemo.domain.service;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService{

    @Override
    public boolean isAdmin() {
        return true;
    }
}
