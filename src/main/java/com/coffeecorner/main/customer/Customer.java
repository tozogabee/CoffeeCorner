package com.coffeecorner.main.customer;

import com.coffeecorner.main.product.Offering;
import com.coffeecorner.main.product.coffee.Coffee;
import com.coffeecorner.main.product.coffee.Extra;
import com.coffeecorner.main.product.juice.Juice;
import com.coffeecorner.main.product.snack.Snack;

import java.math.BigDecimal;
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

    public void orderingCoffee(Coffee coffee,List<Extra> extras) {
        Offering newCoffee = new Coffee(coffee.getName(), coffee.getPrice(), coffee.getCoffeeCupSize());
        if (!this.orders.isEmpty()) {
            newCoffee.setName(coffee.getName());
            BigDecimal actPrice = this.orders.stream().map(offering -> offering.getPrice()).reduce(BigDecimal.ZERO, BigDecimal::add);
            newCoffee.setPrice(actPrice);
            for(Extra extra : extras)
                ((Coffee) newCoffee).addExtra(extra);
            this.orders.add(newCoffee);
            if (this.regularCard.equals(Boolean.TRUE)) {
                Long beverageNum = beverageCounter();
                if (beverageNum % 5 == 0) {
                    this.orders.get((int) (beverageNum - 1)).setPrice(BigDecimal.ZERO);
                }
            }
        } else {
            newCoffee = new Coffee(coffee.getName(), coffee.getPrice(), coffee.getCoffeeCupSize());
            newCoffee.setName(coffee.getName());
            newCoffee.setPrice(coffee.getPrice());
            for(Extra extra : extras)
                ((Coffee) newCoffee).addExtra(extra);
            this.orders.add(newCoffee);
        }

    }

    public void orderingJuice(Juice juice) {
        Long beverageNum = 0l;
        if(regularCard.equals(Boolean.TRUE)) {
             beverageNum = beverageCounter();
        }
        BigDecimal actOrderingPrice = this.orders.stream().map(offering -> offering.getPrice()).reduce(BigDecimal.ZERO,BigDecimal::add);
        actOrderingPrice.add(juice.getPrice());
        Offering newOffer = new Juice();
        if(beverageNum % 5 == 0)
            newOffer = new Juice(juice.getName(), BigDecimal.ZERO, juice.getSize());
        else
            newOffer = new Juice(juice.getName(), actOrderingPrice, juice.getSize());
        this.orders.add(newOffer);
    }

    public void orderingSnack(Snack snack) {
        BigDecimal sumOfPrice = this.orders.stream().map(offering -> offering.getPrice()).reduce(BigDecimal.ZERO,BigDecimal::add);
        sumOfPrice.add(snack.getPrice());
        Offering newSnack = new Snack(snack.getName(), sumOfPrice);
        this.orders.add(newSnack);
    }

    private Long beverageCounter() {
        return this.orders
                .stream()
                .map(offering -> offering instanceof Coffee || offering instanceof Juice)
                .count();
    }

    private Boolean aSnackAndABeverage() {
        if(this.orders.size() == 2){
            Boolean isOneOfSnack = this.orders.stream().map(offering -> offering instanceof Snack).findAny().orElse(Boolean.FALSE);
            Boolean isOneOfBeverage = this.orders.stream().map(offering -> offering instanceof Coffee || offering instanceof Juice).findAny().orElse(Boolean.FALSE);
            if(isOneOfSnack && isOneOfBeverage) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "regularCard=" + regularCard +
                ", orders=" + orders +
                '}';
    }
}
