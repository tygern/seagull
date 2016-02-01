package com.tygern.seagull.staticbirdfoodstore;

import com.tygern.seagull.birdfoodapi.Seed;
import com.tygern.seagull.birdfoodapi.SeedProvider;

import java.util.Arrays;
import java.util.List;

public class StaticSeedProvider implements SeedProvider {
    @Override
    public List<Seed> getList() {
        Seed fennel = new Seed();
        fennel.setType("fennel");
        fennel.setQuantity(7L);

        Seed millet = new Seed();
        millet.setType("millet");
        millet.setQuantity(50L);

        return Arrays.asList(fennel, millet);
    }
}
