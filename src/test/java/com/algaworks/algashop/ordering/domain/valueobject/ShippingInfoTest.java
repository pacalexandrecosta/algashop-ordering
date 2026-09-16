package com.algaworks.algashop.ordering.domain.valueobject;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ShippingInfoTest {

    FullName validFullname = new FullName("John", "Doe");
    Document validDocument = new Document("000-00-0000");
    Phone validPhone = new Phone("000-000-0000");
    Address validAddress = Address.builder()
            .street("Bourbon Street")
            .number("Anonymized")
            .neighborhood("North Ville")
            .city("York")
            .state("South California")
            .zipCode(new ZipCode("12345"))
            .complement(null)
            .build();

    @Test
    @DisplayName("Should reject null fullName")
    void given_null_full_name_when_creating_should_throw_exception() {
        Assertions
                .assertThatExceptionOfType(NullPointerException.class)
                .isThrownBy(() -> new ShippingInfo(null, validDocument, validPhone, validAddress));
    }

    @Test
    @DisplayName("Should reject null document")
    void given_null_document_when_creating_should_throw_exception() {
        Assertions
                .assertThatExceptionOfType(NullPointerException.class)
                .isThrownBy(() -> new ShippingInfo(validFullname, null, validPhone, validAddress));
    }

    @Test
    @DisplayName("Should reject null phone")
    void given_null_phone_when_creating_should_throw_exception() {
        Assertions
                .assertThatExceptionOfType(NullPointerException.class)
                .isThrownBy(() -> new ShippingInfo(validFullname, validDocument, null, validAddress));
    }

    @Test
    @DisplayName("Should reject null address")
    void given_null_address_when_creating_should_throw_exception() {
        Assertions
                .assertThatExceptionOfType(NullPointerException.class)
                .isThrownBy(() -> new ShippingInfo(validFullname, validDocument, validPhone, null));
    }

}