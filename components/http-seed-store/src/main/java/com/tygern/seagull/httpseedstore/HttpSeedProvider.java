package com.tygern.seagull.httpseedstore;

import com.tygern.seagull.birdfoodapi.Seed;
import com.tygern.seagull.birdfoodapi.SeedProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestOperations;

import java.util.List;

public class HttpSeedProvider implements SeedProvider {

    private RestOperations restOperations;
    private String seedUrl;
    private SeedListBuilder seedListBuilder;

    @Autowired
    public HttpSeedProvider(
            RestOperations restOperations,
            @Value("${seed.url}") String seedUrl
    ) {
        this.restOperations = restOperations;
        this.seedUrl = seedUrl;
        this.seedListBuilder = new SeedListBuilder();
    }

    @Override
    public List<Seed> getList() {
        ResponseEntity<SeedListResponse> response = restOperations
                .getForEntity(seedUrl + "/seed", SeedListResponse.class);
        SeedListResponse seedListResponse = response.getBody();

        return seedListBuilder.build(seedListResponse);
    }
}
