package com.coffeecorner.main.product;

import java.math.BigDecimal;

public abstract class Offering {

    private String name;

    private BigDecimal price;

    public Offering() {
    }

    public Offering(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    protected String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    protected BigDecimal getPrice() {
        return price;
    }

    protected void setPrice(BigDecimal price) {
        this.price = price;
    }
}