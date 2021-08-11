package com.kodilla.good.patterns.food2door;

public class OrderRequestRetriever {

    public OrderRequest retrieve() {
        Product product1 = new Product("Kluski", 8.50);
        Order order = new Order(product1, 20.0);
        FoodSupplier foodSupplier = new ExtraFoodShop();
        return new OrderRequest(foodSupplier, order);
    }
}
