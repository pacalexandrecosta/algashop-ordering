package com.algaworks.algashop.ordering.domain.valueobject;

import java.util.Objects;

public record Document(String value) {

    public Document {
        Objects.requireNonNull(value);
        if (value.isBlank() || value.isEmpty()) {
            throw new IllegalArgumentException(("Document cannot be empty or blank"));
        }


    }

    @Override
    public String toString() {
        return value.toString();
    }
}
