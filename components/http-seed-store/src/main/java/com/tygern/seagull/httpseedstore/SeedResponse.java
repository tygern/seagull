package com.tygern.seagull.httpseedstore;

public class SeedResponse {
    private long id;
    private String type;
    private long amount;
    private boolean tasty;

    public SeedResponse() {
    }

    public SeedResponse(long id, String type, long amount, boolean tasty) {
        this.id = id;
        this.type = type;
        this.amount = amount;
        this.tasty = tasty;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public boolean isTasty() {
        return tasty;
    }

    public void setTasty(boolean tasty) {
        this.tasty = tasty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SeedResponse that = (SeedResponse) o;

        if (id != that.id) return false;
        if (amount != that.amount) return false;
        //noinspection SimplifiableIfStatement
        if (tasty != that.tasty) return false;
        return !(type != null ? !type.equals(that.type) : that.type != null);

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (int) (amount ^ (amount >>> 32));
        result = 31 * result + (tasty ? 1 : 0);
        return result;
    }
}
