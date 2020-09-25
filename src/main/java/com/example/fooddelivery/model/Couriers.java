package com.example.fooddelivery.model;

public class Couriers {
    private int courier_id;
    private String courier_name;
    private String courier_secondname;
    private String courier_middlename;
    private double order_cash;
    private int delivery_type;
    private String delivery_type_name;

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

    public String getCourier_middlename() {
        return courier_middlename;
    }

    public void setCourier_middlename(String courier_middlename) {
        this.courier_middlename = courier_middlename;
    }

    public double getOrder_cash() {
        return order_cash;
    }

    public void setOrder_cash(double order_cash) {
        this.order_cash = order_cash;
    }

    public int getDelivery_type() {
        return delivery_type;
    }

    public void setDelivery_type(int delivery_type) {
        this.delivery_type = delivery_type;
    }

    public String getDelivery_type_name() {
        return delivery_type_name;
    }

    public void setDelivery_type_name(String delivery_type_name) {
        this.delivery_type_name = delivery_type_name;
    }
}
