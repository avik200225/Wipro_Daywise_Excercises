package com.wipro.carms.service.impl;

import com.wipro.carms.entity.Car;
import com.wipro.carms.repo.CarRepository;
import com.wipro.carms.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepository carRepository;

    @Override
    public Car createCar(Car car) {
        return carRepository.save(car);
    }

    @Override
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    @Override
    public Car getCarById(int id) {
        return carRepository.findById(id).orElseThrow(() -> new RuntimeException("Car not found"));
    }

    @Override
    public Car updateCar(int id, Car updatedCar) {
        Car existing = getCarById(id);
        existing.setMake(updatedCar.getMake());
        existing.setRegistrationDetail(updatedCar.getRegistrationDetail());
        return carRepository.save(existing);
    }

    @Override
    public void deleteCar(int id) {
        Car car = getCarById(id);
        carRepository.delete(car);
    }
}
