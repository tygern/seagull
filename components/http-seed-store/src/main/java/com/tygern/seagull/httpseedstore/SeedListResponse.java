package com.tygern.seagull.httpseedstore;

import java.util.List;

public class SeedListResponse {
    private List<SeedResponse> seed;

    public SeedListResponse() {
    }

    public SeedListResponse(List<SeedResponse> seed) {
        this.seed = seed;
    }

    public List<SeedResponse> getSeed() {
        return seed;
    }

    public void setSeed(List<SeedResponse> seed) {
        this.seed = seed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SeedListResponse that = (SeedListResponse) o;

        return !(seed != null ? !seed.equals(that.seed) : that.seed != null);

    }

    @Override
    public int hashCode() {
        return seed != null ? seed.hashCode() : 0;
    }
}
