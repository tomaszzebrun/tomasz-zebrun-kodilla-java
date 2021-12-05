package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class PizzaExtraCeeseDecorator extends AbstractPizzaDecorator {

    public PizzaExtraCeeseDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(new BigDecimal(5));
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", dodatkowy ser";
    }
}
