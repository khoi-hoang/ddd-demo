package com.exawizards.ddddemo.domain.service;

import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class RandomUuidGenerator implements UserIdGenerator {

    @Override
    public String generateId() {
        return UUID.randomUUID().toString();
    }
}
