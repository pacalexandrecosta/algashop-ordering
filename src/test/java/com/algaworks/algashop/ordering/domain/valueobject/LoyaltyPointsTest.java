package com.algaworks.algashop.ordering.domain.valueobject;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LoyaltyPointsTest {

    @Test
    void shouldGenerate() {
        var loyaltyPoints = new LoyaltyPoints(10);
        Assertions.assertThat(loyaltyPoints.value()).isEqualTo(10);
    }

    @Test
    void shoudAddValue() {
        var loyaltyPoints = new LoyaltyPoints(10);
        var newloyaltyPoints = loyaltyPoints.add(5);
        Assertions.assertThat(newloyaltyPoints.value()).isEqualTo(15);
        Assertions.assertThat(loyaltyPoints.value()).isEqualTo(10);
    }


    @Test
    void shouldNotAddZeroValue() {
        var loyaltyPoints = new LoyaltyPoints(10);

        Assertions
                .assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> loyaltyPoints.add(0));

        Assertions.assertThat(loyaltyPoints.value()).isEqualTo(10);
    }

    @Test
    void shoudNotAddValue() {
        var loyaltyPoints = new LoyaltyPoints(10);

        Assertions
                .assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> loyaltyPoints.add(-5));

        Assertions.assertThat(loyaltyPoints.value()).isEqualTo(10);

    }

}