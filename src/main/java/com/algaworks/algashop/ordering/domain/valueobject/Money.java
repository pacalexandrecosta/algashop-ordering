package com.algaworks.algashop.ordering.domain.valueobject;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public record Money(BigDecimal value) implements Comparable<Money> {

    public static final Money ZERO = new Money("0");

    public Money {
        Objects.requireNonNull(value);
        if (value.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException();
        }
        value = value.setScale(2, RoundingMode.HALF_EVEN);
    }

    public Money(String value) {
        this(new BigDecimal(value));
    }

    @Override
    public int compareTo(Money o) {
        return o.value().compareTo(o.value());
    }


    public Money add(Money money) {
        Objects.requireNonNull(money);
        return new Money(this.value.add(money.value));
    }

    public Money multiply(Quantity quantity) {
        if (quantity.value() < 1) {
            throw new IllegalArgumentException();
        }
        var quantityBd = new BigDecimal(quantity.value());

        return new Money(this.value().multiply(quantityBd));

    }


    public Money divide(Money money) {
        Objects.requireNonNull(money);
        if (money.equals(Money.ZERO)) {
            throw new IllegalArgumentException();
        }
        return new Money(this.value.divide(money.value, RoundingMode.HALF_EVEN));
    }

}
