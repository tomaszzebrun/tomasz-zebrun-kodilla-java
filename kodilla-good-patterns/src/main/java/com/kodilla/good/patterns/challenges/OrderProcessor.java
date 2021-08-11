package com.kodilla.good.patterns.challenges;

public class OrderProcessor {

    private InformationService informationService;
    private PayService payService;
    private DeliveryService deliveryService;

    public OrderProcessor(final InformationService informationService,
                          final PayService payService,
                          final DeliveryService deliveryService) {
        this.informationService = informationService;
        this.payService = payService;
        this.deliveryService = deliveryService;
    }

    public OrderDto process(final OrderRequest orderRequest) {

        boolean payd = payService.pay(orderRequest.getUser(), orderRequest.getOrder());
        if (payd) {
            informationService.inform(orderRequest.getUser());
            deliveryService.delivery(orderRequest.getUser(), orderRequest.getOrder());
            return new OrderDto(orderRequest.getUser(), true);
        } else {
            return new OrderDto(orderRequest.getUser(), false);
        }
    }
}
