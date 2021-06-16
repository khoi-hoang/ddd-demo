package com.exawizards.ddddemo.application.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ExceptionResponse {
    @JsonProperty("message")
    private final String message;
}
