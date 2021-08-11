package com.kodilla.good.patterns.challenges;

public final class Item {

    private final Product product;
    private final double quantity;

    public Item(final Product product, final double quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public double getQuantity() {
        return quantity;
    }

    public double getValue() {
        return product.getProductPrice() * quantity;
    }
}
