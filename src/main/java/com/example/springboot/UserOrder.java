package com.example.springboot;

import java.util.List;

public class UserOrder {

    private List<List<Integer>> products;

    public UserOrder() {
    }

    public UserOrder(List<List<Integer>> products) {
        this.products = products;
    }

    public List<List<Integer>> getProducts() {
        return products;
    }

    public void setProducts(List<List<Integer>> products) {
        this.products = products;
    }
}
