package com.kodilla.patterns.builder.bigmac;

public enum Sauce {
    STANDARD("standard"),
    THOUSAND_ISLANDS("tysiąc wysp"),
    BARBECUE("barbecue");

    private String name;

    Sauce(String name) {
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
