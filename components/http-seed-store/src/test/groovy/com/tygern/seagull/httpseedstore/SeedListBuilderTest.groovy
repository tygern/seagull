package com.tygern.seagull.httpseedstore

import com.tygern.seagull.birdfoodapi.Seed
import spock.lang.Specification


class SeedListBuilderTest extends Specification {
    SeedListBuilder builder;

    def setup() {
        builder = new SeedListBuilder();
    }

    def testBuild() {
        given:
        SeedResponse poppy = new SeedResponse(1, "poppy", 100, true)
        SeedResponse sesame = new SeedResponse(2, "sesame", 200, false)

        SeedListResponse response = new SeedListResponse([poppy, sesame])

        when:
        List<Seed> seedResult = builder.build(response)

        then:
        seedResult.size() == 2
        seedResult[0].type == "poppy"
        seedResult[0].quantity == 100
        seedResult[1].type == "sesame"
        seedResult[1].quantity == 200

    }
}