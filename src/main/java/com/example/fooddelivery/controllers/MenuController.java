package com.example.fooddelivery.controllers;

import com.example.fooddelivery.model.Menu;
import com.example.fooddelivery.services.MenuService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class MenuController {
    private MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @GetMapping(path = "/menu") //Retrieves all records without JOINing
    public List<Menu> getAllMenu(){
        return menuService.getAllMenu();
    }

    @GetMapping(path = "/menuDetails")//Retrieves all records JOINing menu and stores tables
    public List<Menu> getDetailedMenu(){
        return menuService.getAllDetailedMenu();
    }

    @GetMapping(path = "/menuDetails/{id}")//Retrieves all records JOINing menu and stores tables by ID
    public Menu getDetailedMenuById(@PathVariable int id){
        return menuService.getDetailedMenuById(id);
    }

    @PostMapping(path = "/addMenu")
    public String addNewMenu(@RequestBody Menu menu){
        menuService.addNewMenu(menu);
        return "New menu set is added!";
    }

    @PutMapping(path = "/editMenu/{id}")
    public int editMenu(@PathVariable int id, @RequestBody Menu menu){
        return menuService.editMenu(menu, id);
    }

    @DeleteMapping(path = "/deleteMenu/{id}")
    public String deleteMenu(@PathVariable int id){
        menuService.deleteMenu(id);
        return "Menu set is deleted!";
    }
}
