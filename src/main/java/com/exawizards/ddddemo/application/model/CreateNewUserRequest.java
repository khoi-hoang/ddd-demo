package com.exawizards.ddddemo.application.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CreateNewUserRequest {
    @JsonProperty("name")
    private final String name;
    @JsonProperty("organization")
    private final String organization;
}
