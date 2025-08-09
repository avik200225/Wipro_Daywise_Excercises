package com.wipro.springmvc.service.repo;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class CarRepo {
    public List<String> getCarList() {
        return Arrays.asList("Audi", "Mercedes", "BMW", "Toyota");
    }
}
