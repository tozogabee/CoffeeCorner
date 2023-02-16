package com.coffeecorner.main.product.coffee;

import com.coffeecorner.main.product.Offering;

import java.math.BigDecimal;

public class Coffee extends Offering {

    private CoffeeCupSize coffeeCupSize;

    public Coffee() {
    }

    public Coffee(String name, BigDecimal price, CoffeeCupSize coffeeCupSize) {
        super(name, price);
        this.coffeeCupSize = coffeeCupSize;
    }

    public CoffeeCupSize getCoffeeCupSize() {
        return coffeeCupSize;
    }

    public void setCoffeCupSize(CoffeeCupSize coffeeCupSize) {
        this.coffeeCupSize = coffeeCupSize;
    }
}
