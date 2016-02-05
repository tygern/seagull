package com.tygern.seagull.httpapplication;

import com.tygern.seagull.birdfoodapi.SeedProvider;
import com.tygern.seagull.httpseedstore.HttpSeedProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class SeagullApplicationContext {
    @Bean
    SeedProvider seedProvider(@Value("${seed.url}") String seedUrl) {
        return new HttpSeedProvider(new RestTemplate(), seedUrl);
    }
}
