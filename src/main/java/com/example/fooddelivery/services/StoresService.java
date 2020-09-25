package com.example.fooddelivery.services;

import com.example.fooddelivery.model.Stores;
import com.example.fooddelivery.repositories.StoresRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoresService {
    private StoresRepository storesRepository;

    public StoresService(StoresRepository storesRepository) {
        this.storesRepository = storesRepository;
    }

    public List<Stores> getAllStores() {
        return storesRepository.getAllStores();
    }

    public void addNewStore(Stores stores) {
        storesRepository.addNewStore(stores);
    }

    public Stores getStoreById(int id) {
        return storesRepository.getStoreById(id);
    }

    public Stores getStoreWithNameById(int id) {
        return storesRepository.getStoreWithNameById(id);
    }

    public List<Stores> getAllStoresWithNames() {
        return storesRepository.getAllStoresWithNames();
    }
}
