package com.kodilla.testing;

import com.kodilla.testing.calculator.Calculator;

public class TestingMain {
    public static void main(String[] args) {

        Calculator calculator = new Calculator();

        int resultAdd = calculator.add(3, 6);
        int resultSubtract = calculator.subtract(6,2);

        if (resultAdd == 9) {
            System.out.println("test add OK");
        } else {
            System.out.println("Error add!");
        }

        if (resultSubtract == 4) {
            System.out.println("test subtract OK");
        } else {
            System.out.println("Error subtract!");
        }
    }
}
