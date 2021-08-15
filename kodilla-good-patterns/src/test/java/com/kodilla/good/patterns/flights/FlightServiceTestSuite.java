package com.kodilla.good.patterns.flights;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FlightServiceTestSuite {

    @Test
    void testSearchFlightFrom() {
        //Given
        FlightService flightService = new FlightService(prepareData());

        //When
        List<Flight> resultFrom  = flightService.searchFlightFrom(Citi.Wroclaw);
        //resultFrom.stream().forEach(s -> System.out.println(s));

        //Then
        assertEquals(3, resultFrom.size());
    }

    @Test
    void testSearchFlightTo() {
        //Given
        FlightService flightService = new FlightService(prepareData());

        //When
        List<Flight> resultTo  = flightService.searchFlightTo(Citi.Warszawa);
        //resultTo.stream().forEach(s -> System.out.println(s));

        //Then
        assertEquals(4, resultTo.size());
    }

    @Test
    void searchConnetcingFlight() {
        //Given
        FlightService flightService = new FlightService(prepareData());

        //When
        List<Flight> resultTo  = flightService.searchConnetcingFlight(Citi.Wroclaw, Citi.Warszawa);
        resultTo.stream().forEach(s -> System.out.println(s));

        //Then
        assertEquals(4, resultTo.size());
    }

    private List<Flight> prepareData() {
        Flight flight0 = new Flight(1, Citi.Wroclaw, Citi.Warszawa);
        Flight flight1 = new Flight(2, Citi.Warszawa, Citi.Krakow);
        Flight flight2 = new Flight(3, Citi.Wroclaw, Citi.Krakow);
        Flight flight3 = new Flight(4, Citi.Gdansk, Citi.Warszawa);
        Flight flight4 = new Flight(5, Citi.Poznan, Citi.Wroclaw);
        Flight flight5 = new Flight(6, Citi.Krakow, Citi.Gdansk);
        Flight flight6 = new Flight(7, Citi.Krakow, Citi.Warszawa);
        Flight flight7 = new Flight(8, Citi.Poznan, Citi.Warszawa);
        Flight flight8 = new Flight(9, Citi.Wroclaw, Citi.Poznan);
        Flight flight9 = new Flight(10, Citi.Warszawa, Citi.Poznan);
        List<Flight> result  = new ArrayList<>();
        result.add(flight0);
        result.add(flight1);
        result.add(flight2);
        result.add(flight3);
        result.add(flight4);
        result.add(flight5);
        result.add(flight6);
        result.add(flight7);
        result.add(flight8);
        result.add(flight9);
        return result;
    }
}
