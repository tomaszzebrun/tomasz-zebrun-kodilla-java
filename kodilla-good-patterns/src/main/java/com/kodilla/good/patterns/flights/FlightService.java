package com.kodilla.good.patterns.flights;

import java.util.*;
import java.util.stream.Collectors;

public class FlightService {

    List<Flight> flightList;

    public FlightService(List<Flight> flightList) {
        this.flightList = flightList;
    }

    public List<Flight> searchFlightFrom(Citi citi) {
        return flightList.stream()
                .filter(f -> f.getDepartureAirport() == citi)
                .collect(Collectors.toList());
    }

    public List<Flight> searchFlightTo(Citi citi) {
        return flightList.stream()
                .filter(f -> f.getArrivalAirport() == citi)
                .collect(Collectors.toList());
    }

    public List<Flight> searchConnetcingFlight(Citi citiFrom, Citi citiTo) {
        List<Flight> flightFrom = searchFlightFrom(citiFrom);
        List<Flight> flightTo = searchFlightTo(citiTo);

        List<Citi> connetcingCitiTo = flightTo.stream()
                .map(f -> f.getDepartureAirport())
                .collect(Collectors.toList());
        List<Citi> connetcingCitis = flightFrom.stream()
                .map(f -> f.getArrivalAirport())
                .collect(Collectors.toList()).stream()
                .filter(connetcingCitiTo::contains)
                .collect(Collectors.toList());

        return flightList.stream()
                .filter(f -> f.getDepartureAirport() == citiFrom && connetcingCitis.contains(f.getArrivalAirport()) ||
                        f.getArrivalAirport() == citiTo && connetcingCitis.contains(f.getDepartureAirport()))
                .collect(Collectors.toList());
    }
}
