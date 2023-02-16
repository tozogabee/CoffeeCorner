package com.coffeecorner.main.customer;

import com.coffeecorner.main.product.Offering;
import com.coffeecorner.main.product.coffee.Coffee;
import com.coffeecorner.main.product.coffee.Extra;
import com.coffeecorner.main.product.juice.Juice;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Customer {

    private Boolean regularCard;

    private List<Offering> orders;

    private int beverageCounter;

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

    public void orderingCoffee(Coffee coffee,List<Extra> extras) {
        Offering newCoffee = new Coffee();
        if (!this.orders.isEmpty()) {
            newCoffee.setName(coffee.getName());
            BigDecimal actPrice = this.orders.stream().map(offering -> offering.getPrice()).reduce(BigDecimal.ZERO, BigDecimal::add);
            newCoffee.setPrice(actPrice);
            for(Extra extra : extras)
                ((Coffee) newCoffee).addExtra(extra);
            this.orders.add(newCoffee);
            ++beverageCounter;
            if (this.regularCard.equals(Boolean.TRUE) && beverageCounter % 5 == 0) {
                Long beverageNum = this.orders
                        .stream()
                        .map(offering -> offering instanceof Coffee || offering instanceof Juice)
                        .count();
                if (beverageNum % 5 == 0) {
                    this.orders.get((int) (beverageNum - 1)).setPrice(BigDecimal.ZERO);
                }
            }
        } else {
            this.beverageCounter = 1;
            newCoffee = new Coffee();
            newCoffee.setName(coffee.getName());
            newCoffee.setPrice(coffee.getPrice());
            for(Extra extra : extras)
                ((Coffee) newCoffee).addExtra(extra);
            this.orders.add(newCoffee);
        }

    }

    //public void orderingJuice()





}
