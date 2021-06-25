package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class AvailableAirports {

    private Map<String, Boolean> actualAvailableAirports;

    public AvailableAirports(Map<String, Boolean> actualAvailableAirports) {
        this.actualAvailableAirports = actualAvailableAirports;
    }

    public boolean findFilght(Flight flight) throws RouteNotFoundException {

        if (!actualAvailableAirports.containsKey(flight.getArrivalAirport())) {
            throw new RouteNotFoundException();
        }
        return actualAvailableAirports.get(flight.getArrivalAirport());
    }
}
