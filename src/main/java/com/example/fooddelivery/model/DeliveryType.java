package com.example.fooddelivery.model;

public class DeliveryType {
    private int delivery_type_id;
    private String delivery_type_name;

    public int getDelivery_type_id() {
        return delivery_type_id;
    }

    public void setDelivery_type_id(int delivery_type_id) {
        this.delivery_type_id = delivery_type_id;
    }

    public String getDelivery_type_name() {
        return delivery_type_name;
    }

    public void setDelivery_type_name(String delivery_type_name) {
        this.delivery_type_name = delivery_type_name;
    }


    @Override
    public String toString() {
        return "DeliveryType{" +
                "delivery_type_id=" + delivery_type_id +
                ", delivery_type_name='" + delivery_type_name +
                '}';
    }
}
