package com.example.internetpetshop.Models;


import java.math.BigDecimal;

public class CartItem {
    private final Product product;
    private int quantity;
    private double subTotal;

    public CartItem(Product product) {
        this.product = product;
        this.quantity = 1;
        this.subTotal = product.getPrice().doubleValue();
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getSubTotal() {
        subTotal = product.getPrice().doubleValue() * quantity;
        return subTotal;
    }
}

