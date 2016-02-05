package com.tygern.seagull.mockapplication;

import com.tygern.seagull.birdfoodapi.SeedProvider;
import com.tygern.seagull.staticbirdfoodstore.StaticSeedProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MockSeagullApplicationContext {
    @Bean
    SeedProvider seedProvider() {
        return new StaticSeedProvider();
    }
}
