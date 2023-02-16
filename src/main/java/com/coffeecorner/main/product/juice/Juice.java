package com.coffeecorner.main.product.juice;

import com.coffeecorner.main.product.Offering;

import java.math.BigDecimal;

public class Juice extends Offering {

    private Double size;

    public Juice() {
    }

    public Juice(String name, BigDecimal price, Double size) {
        super(name, price);
        this.size = size;
    }
}
