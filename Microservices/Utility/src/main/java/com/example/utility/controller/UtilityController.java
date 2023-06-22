package com.example.utility.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UtilityController {
    @GetMapping("/hey")
    private String hey(){
        return "hey";
    }
}
