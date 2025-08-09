package com.wipro.carms.service;

import com.wipro.carms.entity.Car;

import java.util.List;

public interface CarService {
    Car createCar(Car car);
    List<Car> getAllCars();
    Car getCarById(int id);
    Car updateCar(int id, Car car);
    void deleteCar(int id);
}
