package com.microservice.internal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class InternalApplication {

    public static void main(String[] args) {
        SpringApplication.run(InternalApplication.class, args);
    }

}
