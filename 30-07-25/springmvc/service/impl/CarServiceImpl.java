package com.wipro.springmvc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.springmvc.service.CarService;
import com.wipro.springmvc.service.repo.CarRepo;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    CarRepo prodRepo;

    @Override
    public List<String> getCarList() {
        return prodRepo.getCarList();
    }
}

