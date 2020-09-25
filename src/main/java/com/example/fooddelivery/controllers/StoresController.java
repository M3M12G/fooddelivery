package com.example.fooddelivery.controllers;

import com.example.fooddelivery.model.Stores;
import com.example.fooddelivery.services.StoresService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class StoresController {
    private StoresService storesService;

    public StoresController(StoresService storesService) {
        this.storesService = storesService;
    }

    @GetMapping(path = "/stores")//Retrieves all records without JOINing
    public List<Stores> getAllStores(){
        return storesService.getAllStores();
    }

    @GetMapping(path = "/stores/{id}")
    public Stores getStoreById(@PathVariable int id){
        return storesService.getStoreById(id);
    }

    @GetMapping(path = "/storesDetails")//Retrieves all records JOINing stores and store_categories tables
    public List<Stores> getAllStoresWithNames(){
        return storesService.getAllStoresWithNames();
    }

    @GetMapping(path = "/storesDetails/{id}")
    public Stores getStoreWithNameById(@PathVariable int id){
        return storesService.getStoreWithNameById(id);
    }

    @PostMapping(path = "/addStore")
    public String addNewStore(@RequestBody Stores stores){
        storesService.addNewStore(stores);
        return "New store is created";
    }
}
