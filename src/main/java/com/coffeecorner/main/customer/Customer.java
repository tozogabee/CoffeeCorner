package com.coffeecorner.main.customer;

import com.coffeecorner.main.product.Offering;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private Boolean regularCard;

    private List<Offering> orders;

    public Customer() {
        this.regularCard = false;
        this.orders = new ArrayList<>();
    }

    public Customer(Boolean regularCard) {
        this.regularCard = regularCard;
        this.orders = new ArrayList<>();
    }

    public Customer(Boolean regularCard, List<Offering> orders) {
        this.regularCard = regularCard;
        this.orders = orders;
    }

    public Boolean getRegularCard() {
        return regularCard;
    }

    public void setRegularCard(Boolean regularCard) {
        this.regularCard = regularCard;
    }

    public List<Offering> getOrders() {
        return orders;
    }

    public void setOrders(List<Offering> orders) {
        this.orders = orders;
    }

}
