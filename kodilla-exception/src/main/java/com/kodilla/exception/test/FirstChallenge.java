package com.kodilla.exception.test;

public class FirstChallenge {

    public double divide(double a, double b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException();
        }
        return a / b;
    }

    public static void main(String[] args) {
        FirstChallenge firstChallenge = new FirstChallenge();
        String result = "";
        try {
            result = Double.toString(firstChallenge.divide(3, 0));
        } catch(ArithmeticException e) {
            result = "Dzielenie przez zero";
        } finally {
            System.out.println(result);
        }
    }
}
