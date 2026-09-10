package com.algaworks.algashop.ordering.domain.valueobject;

import java.util.Objects;

public record FullName(String firstName, String lastName) {

    public FullName {
        Objects.requireNonNull(firstName);
        Objects.requireNonNull(lastName);

        if (firstName.isBlank()) {
            throw new IllegalArgumentException();
        }

        if (lastName.isBlank()) {
            throw new IllegalArgumentException();
        }

        firstName = firstName.trim();
        lastName = lastName.trim();

    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}
