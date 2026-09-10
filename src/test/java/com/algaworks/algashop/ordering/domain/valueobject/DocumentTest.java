package com.algaworks.algashop.ordering.domain.valueobject;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class DocumentTest {

    @Test
    void given_NullDocument_thenThrowException() {
        Assertions
                .assertThatExceptionOfType(NullPointerException.class)
                .isThrownBy(() -> new Document(null));
    }

    @Test
    void given_EmptyDocument_thenThrowException() {
        var futureDate = LocalDate.now().plusDays(1);
        Assertions
                .assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Document(""));
    }

    @Test
    void given_BlankDocument_thenThrowException() {
        var futureDate = LocalDate.now().plusDays(1);
        Assertions
                .assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Document(" "));
    }

    @Test
    void given_ValidDocument_thenCreateDocument() {
        var pastDate = LocalDate.now().minusDays(1);

        Assertions
                .assertThatNoException()
                .isThrownBy(() -> new Document("Document"));
    }


}