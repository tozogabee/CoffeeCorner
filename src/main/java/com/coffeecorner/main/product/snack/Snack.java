package com.coffeecorner.main.product.snack;

import com.coffeecorner.main.product.Offering;

import java.math.BigDecimal;

public class Snack extends Offering {

    public Snack() {
    }

    public Snack(String name, BigDecimal price) {
        super(name, price);
    }
}
