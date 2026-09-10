package com.algaworks.algashop.ordering.domain.valueobject;

import java.util.Objects;

public record Phone(String value) {
    public Phone {
        Objects.requireNonNull(value);
        if (value.isBlank() || value.isEmpty()) {
            throw new IllegalArgumentException(("Phone cannot be empty or blank"));
        }


    }

    @Override
    public String toString() {
        return value.toString();
    }
}
