package com.algaworks.algashop.ordering.domain.valueobject;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class EmailTest {


    @Test
    void should_throwException_whenNullValue() {
        Assertions
                .assertThatExceptionOfType(NullPointerException.class)
                .isThrownBy(() -> new Email(null));
    }

    @Test
    void should_throwException_whenBlank() {
        Assertions
                .assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Email(" "));
    }

    @Test
    void should_throwException_whenEmpty() {
        Assertions
                .assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Email(" "));
    }

    @Test
    void should_throwException_whenInvalid() {
        Assertions
                .assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Email("invalid@invalid@com"));
    }

    @Test
    void should_createEmail_whenItIsValid() {
        Assertions
                .assertThatNoException()
                .isThrownBy(() -> new Email("ok@mail.com"));
    }

}