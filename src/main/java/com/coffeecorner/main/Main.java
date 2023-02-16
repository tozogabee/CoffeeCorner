package com.coffeecorner.main;

import com.coffeecorner.main.customer.Customer;
import com.coffeecorner.main.product.Offering;
import com.coffeecorner.main.product.coffee.Coffee;
import com.coffeecorner.main.product.coffee.CoffeeCupSize;
import com.coffeecorner.main.product.coffee.Extra;
import com.coffeecorner.main.product.juice.Juice;

import java.math.BigDecimal;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Customer customer = customerWithoutRegularCard();
        System.out.println(customer);
    }

    private static Customer customerWithoutRegularCard() {
        Customer customer = new Customer(Boolean.FALSE);
        Offering newCoffe = new Coffee("CybetCat", BigDecimal.valueOf(123.5), CoffeeCupSize.SMALL);
        Offering juice = new Juice("Orange",BigDecimal.valueOf(4),0.25);
        customer.orderingCoffee((Coffee) newCoffe, List.of(new Extra("Extra milk",BigDecimal.valueOf(0.3))));
        return customer;
    }
}
