package com.kodilla.patterns.builder.bigmac;

public enum Ingredient {
    LETTUCE("sałata"),
    ONION("cebula"),
    BACON("bekon"),
    CUCUMBER("ogórek"),
    CHILLI_PEPPERS("papryczki chilli"),
    MUSHROOMS("pieczarki"),
    SHRIMPS("krewetki"),
    CHEESE("ser");

    private String name;

    Ingredient(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
