package com.crdt.creditapi.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {
    private static final Logger logger = LogManager.getLogger(SampleController.class);

    @GetMapping("/greet")
    public String greetMessage(){
        return "Good day to you";
    }
}
