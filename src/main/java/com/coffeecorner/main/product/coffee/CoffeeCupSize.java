package com.coffeecorner.main.product.coffee;

public enum CoffeeCupSize {

    SMALL("small"),
    MEDIUM("medium"),
    LARGE("large");

    String name;

    CoffeeCupSize(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CoffeeCupSize{" +
                "name='" + name + '\'' +
                '}';
    }
}
