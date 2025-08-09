package com.wipro.springbootmvc.repo;

import org.springframework.stereotype.Repository;

import com.wipro.springbootmvc.City;

import java.util.Arrays;
import java.util.List;

@Repository
public class CityRepository {
    public List<City> getAllCities() {
        return Arrays.asList(
            new City("Mumbai"),
            new City("Delhi"),
            new City("Bangalore"),
            new City("Hyderabad"),
            new City("Kolkata"),
            new City("Chennai"),
            new City("Ahmedabad"),
            new City("Pune"),
            new City("Jaipur"),
            new City("Lucknow")
        );
    }
}
