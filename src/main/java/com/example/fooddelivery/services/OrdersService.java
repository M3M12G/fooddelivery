package com.example.fooddelivery.services;


import com.example.fooddelivery.model.Orders;
import com.example.fooddelivery.repositories.OrdersRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersService {
    private OrdersRepository ordersRepository;

    public OrdersService(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    public List<Orders> getAllOrders() {
        return ordersRepository.getAllOrders();
    }

    public List<Orders> getDetailedOrders() {
        return ordersRepository.getDetailedOrders();
    }

    public void cancelOrder(int id) {
        ordersRepository.cancelOrder(id);
    }

    public void addNewOrder(Orders orders) {
        ordersRepository.addNewOrder(orders);
    }

    public Orders getOrderDetailById(int id) {
        return ordersRepository.getOrderDetailById(id);
    }

    public void deleteCancelledOrders() {
        ordersRepository.deleteCancelledOrders();
    }

    public void payFromOrders() {
        ordersRepository.payFromOrders();
    }
}
