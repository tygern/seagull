package com.tygern.seagull.httpseedstore;

import com.tygern.seagull.birdfoodapi.Seed;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class SeedListBuilder {
    public List<Seed> build(SeedListResponse seedListResponse) {
        return seedListResponse.getSeed().stream()
                .map((seedResponse) -> new Seed(seedResponse.getAmount(), seedResponse.getType()))
                .collect(Collectors.toList());
    }
}
