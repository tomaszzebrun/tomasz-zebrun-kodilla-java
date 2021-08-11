package com.kodilla.good.patterns.challenges;

import java.time.LocalDateTime;

public interface PayService {
    boolean pay(User user, Order order);
}
