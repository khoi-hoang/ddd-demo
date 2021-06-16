package com.exawizards.ddddemo.application.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UserManagementResponse {
    @JsonProperty("userId")
    private final String userId;
}
