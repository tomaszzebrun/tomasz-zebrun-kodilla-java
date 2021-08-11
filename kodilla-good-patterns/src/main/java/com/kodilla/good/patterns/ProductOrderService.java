package com.kodilla.good.patterns;

import com.kodilla.good.patterns.challenges.*;

public class ProductOrderService {

    public static void main(String[] args) {
        OrderRequestRetriever orderRequestRetriever = new OrderRequestRetriever();
        OrderRequest orderRequest = orderRequestRetriever.retrieve();

        //System.out.println(orderRequest.getOrder().items.get(0).getProduct().getProductName());;

        OrderProcessor orderProcessor = new OrderProcessor(
                new MailService(), new PaymentService(), new ShipingService());
        orderProcessor.process(orderRequest);

    }
}
