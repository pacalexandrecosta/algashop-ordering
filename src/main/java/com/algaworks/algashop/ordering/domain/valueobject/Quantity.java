package com.algaworks.algashop.ordering.domain.valueobject;

import java.util.Objects;

public record Quantity(Integer value) implements Comparable<Quantity> {

    public static final Quantity ZERO = new Quantity(0);

    public Quantity {
        Objects.requireNonNull(value);
        if (value < 0) {
            throw new IllegalArgumentException();
        }
    }


    @Override
    public int compareTo(Quantity q) {
        return this.value.compareTo(q.value());
    }

    public Quantity add(Quantity other) {
        return new Quantity(this.value + other.value());
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
