package com.microservice.internal.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InternalController {

    @GetMapping("/msg")
    private String hello() {
        return "";
    }
}
