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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal sumPrice(BigDecimal price) {
        return this.getPrice().add(price);
    }
}
