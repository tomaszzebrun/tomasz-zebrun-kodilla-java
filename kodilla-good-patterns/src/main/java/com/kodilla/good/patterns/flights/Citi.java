package com.kodilla.good.patterns.flights;

public enum Citi {
    Warszawa("Warszawa"),
    Krakow("Kraków"),
    Poznan("Poznań"),
    Wroclaw("Wrocław"),
    Gdansk("Gdańsk");

    private String name;

    Citi(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
