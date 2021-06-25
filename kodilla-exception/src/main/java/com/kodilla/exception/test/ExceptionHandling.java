package com.kodilla.exception.test;

public class ExceptionHandling {

    public static void main(String[] args) {

        SecondChallenge secondChallenge = new SecondChallenge();
        String result = "";
        try {
            result = secondChallenge.probablyIWillThrowException(2.0, 3.0);
        } catch (Exception e) {
            result = "Error!";
        } finally {
            System.out.println(result);
        }
    }
}
