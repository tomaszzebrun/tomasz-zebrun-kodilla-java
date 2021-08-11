package com.kodilla.good.patterns.food2door;

public class OrderProcessor {
    private FoodSupplier foodSupplier;

    public OrderProcessor(OrderRequest orderRequest) {
        this.foodSupplier = orderRequest.getFoodSupplier();
    }

    public boolean process(OrderRequest orderRequest) {
        return foodSupplier.process(orderRequest.getOrder());
    }
}
