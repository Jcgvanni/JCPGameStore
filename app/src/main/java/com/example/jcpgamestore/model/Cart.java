package com.example.jcpgamestore.model;

import java.io.Serializable;

public class Cart implements Serializable {

    private int userId;
    private User user;
    private int productId;
    private DataGame product;
    private Double quantity;

    public Cart() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public DataGame getProduct() {
        return product;
    }

    public void setProduct(DataGame product) {
        this.product = product;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Double calculateTotal(){
        Double total = getQuantity() * getProduct().getPrice();
        return total;
    }
}
