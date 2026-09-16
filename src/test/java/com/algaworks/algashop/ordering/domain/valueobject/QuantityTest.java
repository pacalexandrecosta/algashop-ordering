package com.algaworks.algashop.ordering.domain.valueobject;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class QuantityTest {

    @Test
    @DisplayName("Should reject null values")
    void given_null_Value_when_creating_should_throw_exception() {
        Assertions.assertThatExceptionOfType(NullPointerException.class)
                .isThrownBy(() -> new Quantity(null));
    }

    @Test
    @DisplayName("Should reject negative values")
    void given_negative_Value_when_creating_should_throw_exception() {
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Quantity(-1));
    }

    @Test
    @DisplayName("Should accept zero values")
    void given_zero_Value_when_creating_should_throw_exception() {
        Assertions.assertThatNoException()
                .isThrownBy(() -> new Quantity(0));
    }

    @Test
    @DisplayName("Should accept positive values")
    void given_positive_Value_when_creating_should_throw_exception() {
        Assertions.assertThatNoException()
                .isThrownBy(() -> new Quantity(1));
    }

    @Test
    @DisplayName("Zero constant internal value is zero")
    void given_zero_constant_when_creating_should_have_zero_value() {
        Assertions.assertThat(Quantity.ZERO.value()).isEqualTo(0);
    }

    @Test
    @DisplayName("Should return 0 when internal values are the equal")
    void given_sameInternal_whenComparing_shouldReturn0() {
        var q1 = new Quantity(1);
        var q2 = new Quantity(1);
        Assertions.assertThat(q1.compareTo(q2)).isEqualTo(0);
    }

    @Test
    @DisplayName("Should return -1 when internal values are not  equal")
    void given_differentInternal_whenComparing_shouldReturnNegative() {
        var q1 = new Quantity(1);
        var q2 = new Quantity(2);
        Assertions.assertThat(q1.compareTo(q2)).isEqualTo(-1);
    }


    @Test
    @DisplayName("Should return 1 when internal values are not  equal")
    void given_differentInternal_whenComparing_shouldReturnPositive() {
        var q1 = new Quantity(2);
        var q2 = new Quantity(1);
        Assertions.assertThat(q1.compareTo(q2)).isEqualTo(1);
    }

    @Test
    @DisplayName("Should return sum of internal values")
    void add() {

        var q1 = new Quantity(1);
        var q2 = new Quantity(2);
        var q3 = q1.add(q2);

        Assertions.assertThat(q1.value()).isEqualTo(1);
        Assertions.assertThat(q2.value()).isEqualTo(2);
        Assertions.assertThat(q3.value()).isEqualTo(3);

    }
}