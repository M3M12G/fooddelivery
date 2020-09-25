package com.example.fooddelivery.controllers;

import com.example.fooddelivery.model.Couriers;
import com.example.fooddelivery.services.CouriersService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CouriersController {
    private CouriersService couriersService;

    public CouriersController(CouriersService couriersService) {
        this.couriersService = couriersService;
    }

    @GetMapping(path = "/couriers")
    public List<Couriers> getAllCouriers(){
        return couriersService.getAllCouriers();
    }

    @GetMapping(path = "/couriers/{id}")
    public Couriers getCourierById(@PathVariable int id){
        return couriersService.getCourierById(id);
    }

    @PostMapping(path = "/addCourier")
    public String addNewCourier(@RequestBody Couriers couriers){
        couriersService.addCourier(couriers);
        return "New courier is added!";
    }

    @PutMapping(path = "/editCourier/{id}")
    public int editCourier(@PathVariable int id, @RequestBody Couriers couriers){
        return couriersService.editCourier(couriers, id);
    }

    @DeleteMapping(path = "/deleteCourier/{id}")
    public String deleteCourier(@PathVariable int id){
        couriersService.deleteCourier(id);
        return "Courier is deleted";
    }
}
