package com.kodilla.good.patterns.food2door;

public class OrderRequest {
    private FoodSupplier foodSupplier;
    private Order order;

    public OrderRequest(final FoodSupplier foodSupplier, final Order order) {
        this.foodSupplier = foodSupplier;
        this.order = order;
    }

    public FoodSupplier getFoodSupplier() {
        return foodSupplier;
    }

    public Order getOrder() {
        return order;
    }
}
