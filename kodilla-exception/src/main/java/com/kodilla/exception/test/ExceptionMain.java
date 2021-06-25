package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class ExceptionMain {

    public static void main(String[] args) {

        Map<String, Boolean> activeAirports = new HashMap<>();
        activeAirports.put("Wrocław", true);
        activeAirports.put("Warszawa", false);
        activeAirports.put("Kraków", true);
        activeAirports.put("Radom", false);

        AvailableAirports availableAirports = new AvailableAirports(activeAirports);

        Flight flight =
                //new Flight("Wrocław", "Warszawa");
                //new Flight("Wrocław", "Kraków");
                new Flight("Wrocław", "Toruń");

        try {
            if (availableAirports.findFilght(flight)) {
                System.out.println("Lot dostępny");
            } else {
                System.out.println("Lot chwilowo niedostępny");
            }
        } catch (RouteNotFoundException e) {
            System.out.println("Lot niedostępny");
        }

    }
}
