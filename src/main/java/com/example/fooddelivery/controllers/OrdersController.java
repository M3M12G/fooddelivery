package com.example.fooddelivery.controllers;

import com.example.fooddelivery.model.Orders;
import com.example.fooddelivery.services.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrdersController {

//    @Autowired
    private OrdersService ordersService;

    public OrdersController(OrdersService ordersService) {
        this.ordersService = ordersService;
    }



    @GetMapping(path = "/orders")
    public List<Orders> getAllOrder(){
        return ordersService.getAllOrders();
    }

    @GetMapping(path = "/ordersDetails")
    public List<Orders> getDetailedOrders(){
        return ordersService.getDetailedOrders();
    }

    @GetMapping(path = "/ordersDetails/{id}")
    public Orders getOrderDetailsById(@PathVariable int id){
        return ordersService.getOrderDetailById(id);
    }

    @PutMapping(path = "/cancelOrder/{id}")
    public String cancelOrder(@PathVariable int id){
        ordersService.cancelOrder(id);
        return "The order is canceled!";
    }

    @PutMapping(path = "/paySalary")
    public String payFromOrders(){
        ordersService.payFromOrders();
        return "Couriers' salary is updated";
    }

    @PostMapping(path = "/addOrder")
    public String addNewOrder(@RequestBody Orders orders){
        ordersService.addNewOrder(orders);
        return "New Order is added";
    }

    @DeleteMapping(path = "/deleteCanceledOrders")
    public String deleteCanceledOrders(){
        ordersService.deleteCancelledOrders();
        return "All canceled orders are deleted!";
    }

}
