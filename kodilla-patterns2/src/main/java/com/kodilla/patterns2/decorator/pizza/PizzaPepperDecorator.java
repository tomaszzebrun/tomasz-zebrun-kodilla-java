package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class PizzaPepperDecorator extends AbstractPizzaDecorator {

    public PizzaPepperDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(new BigDecimal(3));
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", papryka";
    }
}
