package com.kodilla.good.patterns.challenges;

public final class Product {

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
        if (!(o instanceof Product)) return false;
        Product that = (Product) o;
        return productName.equals(that.productName);
    }
}
