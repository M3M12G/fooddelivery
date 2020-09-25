package com.example.fooddelivery.controllers;

import com.example.fooddelivery.model.DeliveryType;
import com.example.fooddelivery.services.DeliveryTypeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeliveryTypeController {
    private DeliveryTypeService deliveryTypeService;

    public DeliveryTypeController(DeliveryTypeService deliveryTypeService) {
        this.deliveryTypeService = deliveryTypeService;
    }

    @GetMapping(path = "/deliverytypes")
    public List<DeliveryType> getAllDeliveryTypes(){
        return deliveryTypeService.getAllDeliveryTypes();
    }

    @GetMapping(path = "/deliverytypes/{id}")
    public DeliveryType getDeliveryTypeById(@PathVariable int id){
        return deliveryTypeService.getDeliveryTypesById(id);
    }

    @PostMapping(path = "/adddeliverytype")
    public String addNewDeliveryType(@RequestBody DeliveryType deliveryType){
        deliveryTypeService.addNewDeliveryType(deliveryType);
        return "New Delivery Type is added";
    }

    @PutMapping(path = "/editdeliverytype/{id}")
    public int editDeliveryType(@PathVariable int id,@RequestBody DeliveryType deliveryType){
        return deliveryTypeService.editDeliveryType(deliveryType,id);
    }

    @DeleteMapping(path = "/deletedeliverytype/{id}")
    public String deleteDeliveryType(@PathVariable int id){
        deliveryTypeService.deleteDeliveryType(id);
        return "The delivery type is deleted";
    }
}
