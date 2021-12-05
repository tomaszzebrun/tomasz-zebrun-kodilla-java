package com.kodilla.patterns2.decorator.pizza;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class PizzaTestSuite {

    @Test
    public void testBasicPizza() {
        //Given
        Pizza thePizza = new BasicPizza();
        //When
        BigDecimal theCost = thePizza.getCost();
        String description = thePizza.getDescription();
        System.out.println("Pizza: " + description);
        System.out.println("Cena: " + theCost);
        //Then
        assertEquals(new BigDecimal(15), theCost);
        assertEquals("ciasto i sos pomidorowy z serem", description);
    }

    @Test
    public void testPizzaWithBaconPepperExtraCeese() {
        //Given
        Pizza thePizza = new BasicPizza();
        thePizza = new PizzaBaconDecorator(thePizza);
        thePizza = new PizzaPepperDecorator(thePizza);
        thePizza = new PizzaExtraCeeseDecorator(thePizza);
        //When
        BigDecimal theCost = thePizza.getCost();
        String description = thePizza.getDescription();
        System.out.println("Pizza: " + description);
        System.out.println("Cena: " + theCost);
        //Then
        assertEquals(new BigDecimal(26), theCost);
        assertEquals("ciasto i sos pomidorowy z serem, bekon, papryka, dodatkowy ser", description);
    }
}
