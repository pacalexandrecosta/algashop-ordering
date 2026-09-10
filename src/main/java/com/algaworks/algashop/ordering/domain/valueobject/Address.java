package com.algaworks.algashop.ordering.domain.valueobject;

import com.algaworks.algashop.ordering.domain.validator.FieldValidations;
import lombok.Builder;

import java.util.Objects;

@Builder(toBuilder = true)
public record Address(
        String street,
        String number,
        String complement,
        String neighborhood,
        String city,
        String state,
        ZipCode zipCode
) {

    public Address {
        FieldValidations.requiresNotBlank(street);
        FieldValidations.requiresNotBlank(neighborhood);
        FieldValidations.requiresNotBlank(number);
        FieldValidations.requiresNotBlank(city);
        FieldValidations.requiresNotBlank(state);
        Objects.requireNonNull(zipCode);
    }
}
