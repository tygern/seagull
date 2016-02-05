package com.tygern.seagull.mockapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.tygern.seagull")
public class MockSeagullApplication {
    public static void main(String[] args) {
        SpringApplication.run(MockSeagullApplication.class, args);
    }
}
