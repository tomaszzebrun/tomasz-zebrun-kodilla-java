package com.kodilla.good.patterns.food2door;

public class Product {
    private final String productName;
    private final double productPrice;

    public Product(final String productName, final double productPrice) {
        this.productName = productName;
        this.productPrice = productPrice;
    }

    public String getProductName() {
        return productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof com.kodilla.good.patterns.challenges.Product)) return false;
        Product that = (Product) o;
        return productName.equals(that.productName);
    }
}
