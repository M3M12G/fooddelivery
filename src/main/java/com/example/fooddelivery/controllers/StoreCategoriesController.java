package com.example.fooddelivery.controllers;

import com.example.fooddelivery.model.StoreCategories;
import com.example.fooddelivery.services.StoreCategoriesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StoreCategoriesController {
    private final StoreCategoriesService storeCategoriesService;

    public StoreCategoriesController(StoreCategoriesService storeCategoriesService) {
        this.storeCategoriesService = storeCategoriesService;
    }

    @GetMapping(path = "/categories")
    public List<StoreCategories> getAllCategories(){
        return storeCategoriesService.getAllCategories();
    }

    @GetMapping(path = "/categories/{id}")
    public StoreCategories getCategoryById(@PathVariable int id){
       return storeCategoriesService.getCategoryById(id);
    }


    @PostMapping(path = "/addCategory")
    public String addNewCategory(@RequestBody StoreCategories storeCategories){
        storeCategoriesService.addNewCategory(storeCategories);
        return "New category is added";
    }

    @PutMapping(path = "/editCategory/{id}")
    public int editCategory(@PathVariable int id, @RequestBody StoreCategories storeCategories){
        return storeCategoriesService.updateCategory(storeCategories,id);
    }

    @DeleteMapping(path = "/deleteCategory/{id}")
    public String deleteCategory(@PathVariable int id){
        storeCategoriesService.deleteCategory(id);
        return "The category is deleted";
    }
}
