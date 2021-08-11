package com.kodilla.good.patterns.challenges;

import java.util.*;

public class OrderRequestRetriever {

    public OrderRequest retrieve() {
        User user = new User("John", "Smith");

        List<Item> items = new ArrayList<>();
        Product product1 = new Product("Kapcie", 17.50);
        Item item1 = new Item(product1, 2.0);
        items.add(item1);
        Order order = new Order(items);

        return new OrderRequest(user, order);
    }
}
