package com.kodilla.good.patterns.challenges;

public class OrderDto {
    public User user;
    public boolean isPayd;

    public OrderDto(final User user, final boolean isPayd) {
        this.user = user;
        this.isPayd = isPayd;
    }

    public User getUser() { return user; }

    public boolean isRented() { return isPayd; }
}
