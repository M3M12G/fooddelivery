package com.example.fooddelivery.services;

import com.example.fooddelivery.model.Menu;
import com.example.fooddelivery.repositories.MenuRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class MenuService {
    private MenuRepository menuRepository;

    public MenuService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    public List<Menu> getAllMenu() {
        return menuRepository.getAllMenu();
    }

    public void addNewMenu(Menu menu) {
        menuRepository.addNewMenu(menu);
    }

    public int editMenu(Menu menu, int id) {
        return menuRepository.editMenu(menu, id);
    }

    public void deleteMenu(int id) {
        menuRepository.deleteMenu(id);
    }

    public List<Menu> getAllDetailedMenu() {
        return menuRepository.getAllDetailedMenu();
    }

    public Menu getDetailedMenuById(int id) {
        return menuRepository.getDetailedMenuById(id);
    }
}
