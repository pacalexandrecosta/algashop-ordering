package com.algaworks.algashop.ordering.domain.valueobject;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class MoneyTest {
    @Test
    @DisplayName("Should reject null values")
    void given_null_BigDecimalValue_when_creating_should_throw_exception() {
        Assertions.assertThatExceptionOfType(NullPointerException.class)
                .isThrownBy(() -> new Money((BigDecimal) null));
    }

    @Test
    @DisplayName("Should reject null values")
    void given_null_StringValue_when_creating_should_throw_exception() {
        Assertions.assertThatExceptionOfType(NullPointerException.class)
                .isThrownBy(() -> new Money((String) null));
    }

    @Test
    @DisplayName("Should reject negative values")
    void given_negative_StringValue_when_creating_should_throw_exception() {
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Money("-1"));
    }

    @Test
    @DisplayName("Should reject negative values")
    void given_negative_BigDecimalValue_when_creating_should_throw_exception() {
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Money((new BigDecimal("-1"))));
    }

    @Test
    @DisplayName("Should reject invalid string values")
    void given_invalid_string_Value_when_creating_should_throw_exception() {
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Money((new BigDecimal("invalid"))));
    }

    @Nested
    class Add {
        @Test
        @DisplayName("Should reject null values")
        void given_null_value_when_adding_then_should_throw_exception() {
            var money = new Money("100");
            Assertions
                    .assertThatExceptionOfType(NullPointerException.class)
                    .isThrownBy(() -> money.add(null));
        }

        @Test
        @DisplayName("Should add internal values")
        void given_valid_money_objects_when_adding_then_should_add_internal_values() {
            var moneyA = new Money("100");
            var moneyB = new Money("200");


            var addedMoney = moneyA.add(moneyB);

            var expectedMoney = new Money("300");

            Assertions
                    .assertThat(addedMoney)
                    .isEqualTo(expectedMoney);

            Assertions
                    .assertThat(moneyA)
                    .isEqualTo(new Money("100"));

            Assertions
                    .assertThat(moneyB)
                    .isEqualTo(new Money("200"));
        }

        @Test
        @DisplayName("ZERO plus zero equals zero")
        void given_zero_objects_when_adding_then_should_return_zero() {
            var moneyA = Money.ZERO;
            var moneyB = Money.ZERO;


            var addedMoney = moneyA.add(moneyB);

            var expectedMoney = new Money("0");

            Assertions
                    .assertThat(addedMoney)
                    .isEqualTo(expectedMoney);

            Assertions
                    .assertThat(moneyA)
                    .isEqualTo(new Money("0"));

            Assertions
                    .assertThat(moneyB)
                    .isEqualTo(new Money("0"));
        }

    }

    @Nested
    class Multiply {
        @Test
        @DisplayName("Should reject multiply for quantity zero")
        void given_quantity_zero_when_multiplying_shouldThrowException() {
            var qty = Quantity.ZERO;
            var money = new Money("100");
            Assertions
                    .assertThatExceptionOfType(IllegalArgumentException.class)
                    .isThrownBy(() -> money.multiply(qty));
        }

        @Test
        @DisplayName("Should multiply internal value  by internal value ")
        void given_quantity_when_multiplying_shouldMultiplyInternalValue() {

            var qty = new Quantity(10);
            var money = new Money(new BigDecimal("100"));

            var expectedNewMoney = new Money("1000");

            var newMoney = money.multiply(qty);

            Assertions
                    .assertThat(newMoney)
                    .isEqualTo(expectedNewMoney);
        }

        @Test
        @DisplayName("Should return Money.ZERO when multiplying Money.Zero")
        void given_any_quantity_when_multiplying_by_zero_money_shouldReturnMoneyZero() {

            var qty = new Quantity(10);
            var money = Money.ZERO;

            var expectedNewMoney = new Money("0");

            var newMoney = money.multiply(qty);

            Assertions
                    .assertThat(newMoney)
                    .isEqualTo(expectedNewMoney);
        }

        @Test
        @DisplayName("Should preserve money  when multiplying")
        void when_multiplying_shouldPreserveMoney() {

            var qty = new Quantity(10);
            var before = new Money(new BigDecimal("100"));

            before.multiply(qty);


            Assertions
                    .assertThat(before)
                    .isEqualTo(new Money("100"));
        }
    }

    @Nested
    class Divide {
        @Test
        @DisplayName("Should reject null values")
        void given_null_value_when_adding_then_should_throw_exception() {
            var money = new Money("100");
            Assertions
                    .assertThatExceptionOfType(NullPointerException.class)
                    .isThrownBy(() -> money.divide(null));
        }

        @Test
        @DisplayName("Should divided internal values")
        void given_valid_money_objects_when_adding_then_should_add_internal_values() {
            var moneyA = new Money("200");
            var moneyB = new Money("30");


            var result = moneyA.divide(moneyB);

            var expectedMoney = new Money("6.67");

            Assertions
                    .assertThat(result)
                    .isEqualTo(expectedMoney);

            Assertions
                    .assertThat(moneyA)
                    .isEqualTo(new Money("200"));

            Assertions
                    .assertThat(moneyB)
                    .isEqualTo(new Money("30"));
        }

        @Test
        @DisplayName("Should reject division by zero")
        void given_zero_objects_when_adding_then_should_return_zero() {
            var moneyA = new Money("100");
            var moneyB = Money.ZERO;


            Assertions
                    .assertThatExceptionOfType(IllegalArgumentException.class)
                    .isThrownBy(() -> moneyA.divide(moneyB));


            Assertions
                    .assertThat(moneyA)
                    .isEqualTo(new Money("100"));

            Assertions
                    .assertThat(moneyB)
                    .isEqualTo(new Money("0"));
        }

    }


}