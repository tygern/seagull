package com.tygern.seagull.httpapplication;

import com.tygern.seagull.birdfoodapi.SeedProvider;
import com.tygern.seagull.httpseedstore.HttpSeedProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@ComponentScan("com.tygern.seagull")
public class SeagullApplication {

    public static void main(String[] args) {
        SpringApplication.run(SeagullApplication.class, args);
    }

    @Bean
    SeedProvider seedProvider(@Value("${seed.url}") String seedUrl) {
        return new HttpSeedProvider(new RestTemplate(), seedUrl);
    }
}
