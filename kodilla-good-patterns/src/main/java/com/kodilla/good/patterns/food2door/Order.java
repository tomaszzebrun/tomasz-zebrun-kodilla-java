package com.kodilla.good.patterns.food2door;

public class Order {
    private final Product product;
    private final double quantity;

    public Order(final Product product, final double quantity) {
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
