package com.exawizards.ddddemo.domain.model;

import lombok.Data;

@Data
public class User {
    private final String id;
    private final String name;
    private final String organization;
}
