package com.algaworks.algashop.ordering.domain.valueobject;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public record BirthDate(LocalDate value) {

    public BirthDate {
        Objects.requireNonNull(value);
        if (value.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Data de nascimento não pode ser data futura");
        }
    }

    Integer age() {
        return (int) ChronoUnit.YEARS.between(value, LocalDate.now());
    }

    @Override
    public String toString() {
        return value.format(DateTimeFormatter.ISO_DATE);
    }
}
