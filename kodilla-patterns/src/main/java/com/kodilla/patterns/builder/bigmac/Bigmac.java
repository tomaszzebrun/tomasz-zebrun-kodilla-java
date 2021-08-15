package com.kodilla.patterns.builder.bigmac;

import java.util.*;

public final class Bigmac {

    private final Bun bun;
    private final int burgers;
    private final Sauce sauce;
    private List<Ingredient> ingredients = new ArrayList<>();

    public static class BigmacBuilder {
        private Bun bun;
        private int burgers;
        private Sauce sauce;
        private List<Ingredient> ingredients = new ArrayList<>();

        public Bigmac.BigmacBuilder bun(Bun bun) {
            this.bun = bun;
            return this;
        }

        public Bigmac.BigmacBuilder burgers(int burgers) {
            this.burgers = burgers;
            return this;
        }

        public Bigmac.BigmacBuilder sauce(Sauce sauce) {
            this.sauce = sauce;
            return this;
        }

        public Bigmac.BigmacBuilder ingredient(Ingredient ingredient) {
            ingredients.add(ingredient);
            return this;
        }

        public Bigmac build() {
            return new Bigmac(bun, burgers, sauce, ingredients);
        }
    }

    private Bigmac(final Bun bun, final int burgers, final Sauce sauce, List<Ingredient> ingredients) {
        this.bun = bun;
        this.burgers = burgers;
        this.sauce = sauce;
        this.ingredients = new ArrayList<>(ingredients);
    }

    public Bun getBun() {
        return bun;
    }

    public int getBurgers() {
        return burgers;
    }

    public Sauce getSauce() {
        return sauce;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    @Override
    public String toString() {
        return "Bigmac{" +
                "bun=" + bun +
                ", burgers=" + burgers +
                ", sauce=" + sauce +
                ", ingredients=" + ingredients +
                '}';
    }
}
