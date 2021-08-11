package com.kodilla.good.patterns.flights;

import java.util.Objects;

public class Flight {

    private int idFlight;
    private Citi departureAirport;
    private Citi arrivalAirport;

    public Flight(int idFlight, Citi departureAirport, Citi arrivalAirport) {
        this.idFlight = idFlight;
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
    }

    public int getIdFlight() {
        return idFlight;
    }

    public Citi getDepartureAirport() {
        return departureAirport;
    }

    public Citi getArrivalAirport() {
        return arrivalAirport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return idFlight == flight.idFlight && Objects.equals(departureAirport, flight.departureAirport) && Objects.equals(arrivalAirport, flight.arrivalAirport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idFlight);
    }

    @Override
    public String toString() {
        return "Flight{" +
                "idFlight=" + idFlight +
                ", departureAirport=" + departureAirport +
                ", arrivalAirport=" + arrivalAirport +
                '}';
    }
}
