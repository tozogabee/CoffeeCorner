package com.coffeecorner.main.product.coffee;

import com.coffeecorner.main.product.Offering;

import java.math.BigDecimal;

public class Extra extends Offering {

    public Extra() {
    }

    public Extra(String name, BigDecimal price) {
        super(name, price);
    }

    @Override
    public String toString() {
        return "Extra{ " +
                "name=" +this.getName()+
                "price="+this.getPrice()+
                "}";
    }
}
