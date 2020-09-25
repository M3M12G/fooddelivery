package com.example.fooddelivery.services;

import com.example.fooddelivery.model.StoreCategories;
import com.example.fooddelivery.repositories.StoreCategoriesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreCategoriesService {

    private final StoreCategoriesRepository storeCategoriesRepository;

    public StoreCategoriesService(StoreCategoriesRepository storeCategoriesRepository) {
        this.storeCategoriesRepository = storeCategoriesRepository;
    }

    public List<StoreCategories> getAllCategories() {
        return storeCategoriesRepository.getAllCategories();
    }

    public StoreCategories getCategoryById(int id) {
        return storeCategoriesRepository.getCategoryById(id);
    }

    public void addNewCategory(StoreCategories storeCategories) {
        storeCategoriesRepository.insertCategory(storeCategories);
    }

    public void deleteCategory(int id) {
        storeCategoriesRepository.deleteCategory(id);
    }

    public int updateCategory(StoreCategories storeCategories, int id) {
        return storeCategoriesRepository.updateCategory(storeCategories,id);
    }

}
