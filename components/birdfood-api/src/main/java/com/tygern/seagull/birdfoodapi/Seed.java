package com.tygern.seagull.birdfoodapi;

public class Seed {
    long quantity;
    String type;

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Seed seed = (Seed) o;

        if (quantity != seed.quantity) return false;
        return !(type != null ? !type.equals(seed.type) : seed.type != null);

    }

    @Override
    public int hashCode() {
        int result = (int) (quantity ^ (quantity >>> 32));
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }
}
