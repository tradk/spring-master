package com.tradk.model;

public class Product {
    private int id;
    private String name;
    private String category;
    private String status;
    private int price;

    public Product() {
    }

    public Product(String name, String category, String status, int price) {
        this.name = name;
        this.category = category;
        this.status = status;
        this.price = price;
    }

    public Product(int id, String name, String category, String status, int price) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.status = status;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
