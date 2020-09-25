package com.example.fooddelivery.model;

public class Stores {
    private int store_id;
    private String store_name;
    private int store_category;
    private String categoryName;

    public int getStore_id() {
        return store_id;
    }

    public void setStore_id(int store_id) {
        this.store_id = store_id;
    }

    public String getStore_name() {
        return store_name;
    }

    public void setStore_name(String store_name) {
        this.store_name = store_name;
    }

    public int getStore_category() {
        return store_category;
    }

    public void setStore_category(int store_category) {
        this.store_category = store_category;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
