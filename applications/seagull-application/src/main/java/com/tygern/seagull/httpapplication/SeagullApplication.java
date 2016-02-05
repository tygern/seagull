package com.tygern.seagull.httpapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.tygern.seagull")
public class SeagullApplication {
    public static void main(String[] args) {
        SpringApplication.run(SeagullApplication.class, args);
    }
}
