package com.coffeecorner.main.product.coffee;

import com.coffeecorner.main.product.Offering;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Coffee extends Offering {

    private CoffeeCupSize coffeeCupSize;
    private List<Extra> extras;

    public Coffee() {
    }

    public Coffee(String name, BigDecimal price, CoffeeCupSize coffeeCupSize) {
        super(name, price);
        this.coffeeCupSize = coffeeCupSize;
        this.extras = new ArrayList<>();
    }

    public Coffee(String name, BigDecimal price, CoffeeCupSize coffeeCupSize, List<Extra> extras) {
        super(name, price);
        this.coffeeCupSize = coffeeCupSize;
        this.extras = extras;
    }

    public CoffeeCupSize getCoffeeCupSize() {
        return coffeeCupSize;
    }

    public void setCoffeCupSize(CoffeeCupSize coffeeCupSize) {
        this.coffeeCupSize = coffeeCupSize;
    }

    public void setCoffeeCupSize(CoffeeCupSize coffeeCupSize) {
        this.coffeeCupSize = coffeeCupSize;
    }

    public List<Extra> getExtras() {
        return extras;
    }

    public void setExtras(List<Extra> extras) {
        this.extras = extras;
    }

    public void addExtra(Extra extra) {
        this.extras.add(extra);
        BigDecimal newPrice = extra.getPrice().add(this.getPrice());
        this.setPrice(newPrice);
    }

    @Override
    public String toString() {
        return "Coffee: " +
                "\t price = "+this.getPrice()+"" +
                "\t name ="+this.getName()+""+
                "\t size ="+this.getCoffeeCupSize();
    }
}
