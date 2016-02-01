package com.tygern.seagull;

import com.tygern.seagull.birdfoodapi.SeedProvider;
import com.tygern.seagull.staticbirdfoodstore.StaticSeedProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SeagullApplication {

	public static void main(String[] args) {
		SpringApplication.run(SeagullApplication.class, args);
	}

	@Bean
	SeedProvider seedProvider() {
		return new StaticSeedProvider();
	}
}
