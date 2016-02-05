package com.tygern.seagull.mockapplication;

import com.tygern.seagull.birdfoodapi.SeedProvider;
import com.tygern.seagull.staticbirdfoodstore.StaticSeedProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.tygern.seagull")
public class MockSeagullApplication {

    public static void main(String[] args) {
        SpringApplication.run(MockSeagullApplication.class, args);
    }

    @Bean
    SeedProvider seedProvider() {
        return new StaticSeedProvider();
    }
}
