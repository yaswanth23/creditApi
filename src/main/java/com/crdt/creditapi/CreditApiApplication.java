package com.crdt.creditapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class CreditApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(CreditApiApplication.class, args);
    }

}
