package com.kodilla.patterns.builder.bigmac;

public enum Bun {
    WITH_SESAME("bułka z sezamem"),
    WITHOUT_SESAME("bółka");

    private String name;

    Bun(String name) {
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
