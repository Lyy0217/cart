package com.lyy.cart.bean;

public class OrderItem {
    private int id;
    private Product product;
    private int num;
    private Order order;

    public void setOrder(Order order) {
        this.order = order;
    }

    public Order getOrder() {
        return order;
    }

    public int getId() {
        return id;
    }

    public Product getProduct() {
        return product;
    }

    public int getNum() {
        return num;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setNum(int num) {
        this.num = num;
    }
}