package com.algaworks.algashop.ordering.domain.valueobject;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class BirthDateTest {


    @Test
    void given_NullDate_thenThrowException() {
        Assertions
                .assertThatExceptionOfType(NullPointerException.class)
                .isThrownBy(() -> new BirthDate(null));
    }

    @Test
    void given_FutureDate_thenThrowException() {
        var futureDate = LocalDate.now().plusDays(1);
        Assertions
                .assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new BirthDate(futureDate));
    }

    @Test
    void given_ValidPastDate_thenCreateBirthDate() {
        var pastDate = LocalDate.now().minusDays(1);

        Assertions
                .assertThatNoException()
                .isThrownBy(() -> new BirthDate(pastDate));
    }

    @Test
    void shouldCalculateYears() {
        var value = LocalDate.of(2000, 12, 1);

        var birthDate = new BirthDate(value);

        Assertions
                .assertThat(birthDate.age())
                .isGreaterThanOrEqualTo(25);
    }


}