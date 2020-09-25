package com.example.fooddelivery.model;

import java.sql.Timestamp;

public class Orders {
    private int order_id;
    private String client_number;
    private int menu_id;
    private String foods;
    private double price;
    private Timestamp order_time;
    private int courier_id;
    private String courier_name;
    private String courier_secondname;
    private Boolean order_status;

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public String getClient_number() {
        return client_number;
    }

    public void setClient_number(String client_number) {
        this.client_number = client_number;
    }

    public int getMenu_id() {
        return menu_id;
    }

    public void setMenu_id(int menu_id) {
        this.menu_id = menu_id;
    }

    public String getFoods() {
        return foods;
    }

    public void setFoods(String foods) {
        this.foods = foods;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Timestamp getOrder_time() {
        return order_time;
    }

    public void setOrder_time(Timestamp order_time) {
        this.order_time = order_time;
    }

    public int getCourier_id() {
        return courier_id;
    }

    public void setCourier_id(int courier_id) {
        this.courier_id = courier_id;
    }

    public String getCourier_name() {
        return courier_name;
    }

    public void setCourier_name(String courier_name) {
        this.courier_name = courier_name;
    }

    public String getCourier_secondname() {
        return courier_secondname;
    }

    public void setCourier_secondname(String courier_secondname) {
        this.courier_secondname = courier_secondname;
    }

    public Boolean getOrder_status() {
        return order_status;
    }

    public void setOrder_status(Boolean order_status) {
        this.order_status = order_status;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "order_id=" + order_id +
                ", client_number='" + client_number + '\'' +
                ", menu_id=" + menu_id +
                ", foods='" + foods + '\'' +
                ", price=" + price +
                ", order_time=" + order_time +
                ", courier_id=" + courier_id +
                ", courier_name='" + courier_name + '\'' +
                ", courier_secondname='" + courier_secondname + '\'' +
                ", order_status=" + order_status +
                '}';
    }
}
