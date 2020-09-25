package com.example.fooddelivery.services;


import com.example.fooddelivery.model.DeliveryType;
import com.example.fooddelivery.repositories.DeliveryTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryTypeService {
    private final DeliveryTypeRepository deliveryTypeRepository;

    public DeliveryTypeService(DeliveryTypeRepository deliveryTypeRepository) {
        this.deliveryTypeRepository = deliveryTypeRepository;
    }

    public List<DeliveryType> getAllDeliveryTypes() {
        return deliveryTypeRepository.getAllDeliveryTypes();
    }

    public void addNewDeliveryType(DeliveryType deliveryType) {
        deliveryTypeRepository.insertNewDeliveryType(deliveryType);
    }

    public int editDeliveryType(DeliveryType deliveryType, int id) {
       return deliveryTypeRepository.updateDeliveryType(deliveryType, id);
    }

    public void deleteDeliveryType(int id) {
        deliveryTypeRepository.deleteDeliveryType(id);
    }

    public DeliveryType getDeliveryTypesById(int id) {
        return deliveryTypeRepository.getDeliveryTypeById(id);
    }
}
