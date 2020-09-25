package com.example.fooddelivery.services;

import com.example.fooddelivery.model.Couriers;
import com.example.fooddelivery.repositories.CouriersRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CouriersService {
    private CouriersRepository couriersRepository;

    public CouriersService(CouriersRepository couriersRepository) {
        this.couriersRepository = couriersRepository;
    }

    public List<Couriers> getAllCouriers() {
        return couriersRepository.getAllCouriers();
    }

    public Couriers getCourierById(int id) {
        return couriersRepository.getCourierById(id);
    }

    public void addCourier(Couriers couriers) {
        couriersRepository.addCourier(couriers);
    }

    public int editCourier(Couriers couriers, int id) {
        return couriersRepository.editCourier(couriers, id);
    }

    public void deleteCourier(int id) {
        couriersRepository.deleteCourier(id);
    }
}
