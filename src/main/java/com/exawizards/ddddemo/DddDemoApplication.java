package com.exawizards.ddddemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DddDemoApplication {

    public static void main(String[] args) {
        var app = new SpringApplication(DddDemoApplication.class);
        app.setWebApplicationType(WebApplicationType.NONE);
        app.run();
    }
}
