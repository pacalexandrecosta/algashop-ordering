package com.algaworks.algashop.ordering.domain.valueobject;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ProductNameTest {

    @Test
    @DisplayName("Should reject null values")
    void given_nullValue_when_create_then_throwException() {
        Assertions.assertThatExceptionOfType(NullPointerException.class)
                .isThrownBy(() -> new ProductName(null));
    }

    @Test
    @DisplayName("Should reject blank values")
    void given_blankValue_when_create_then_throwException() {
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new ProductName(""));
    }

    @Test
    @DisplayName("Should reject blank values")
    void given_blankButNotmptyValue_when_create_then_throwException() {
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new ProductName(" "));
    }


}