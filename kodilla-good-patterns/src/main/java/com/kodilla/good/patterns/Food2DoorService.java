package com.kodilla.good.patterns;

import com.kodilla.good.patterns.food2door.OrderProcessor;
import com.kodilla.good.patterns.food2door.OrderRequest;
import com.kodilla.good.patterns.food2door.OrderRequestRetriever;

public class Food2DoorService {

    public static void main(String[] args) {
        OrderRequestRetriever orderRequestRetriever = new OrderRequestRetriever();
        OrderRequest orderRequest = orderRequestRetriever.retrieve();

        //System.out.println(orderRequest.getOrder().getProduct().getProductName());;

        OrderProcessor orderProcessor = new OrderProcessor(orderRequest);
        orderProcessor.process(orderRequest);

    }
}
