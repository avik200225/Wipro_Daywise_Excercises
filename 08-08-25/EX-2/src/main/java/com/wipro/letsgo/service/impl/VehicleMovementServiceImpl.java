package com.wipro.letsgo.service.impl;
import com.wipro.letsgo.entity.VehicleMovement;
import com.wipro.letsgo.repo.VehicleMovementRepository;
import com.wipro.letsgo.service.VehicleMovementService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VehicleMovementServiceImpl implements VehicleMovementService {

    @Autowired
	VehicleMovementRepository repository;

    public VehicleMovementServiceImpl(VehicleMovementRepository repository) {
        this.repository = repository;
    }

    @Override
    public VehicleMovement saveMovement(VehicleMovement movement) {
        return repository.save(movement);
    }

    @Override
    public List<VehicleMovement> getAllMovements() {
        return repository.findAll();
    }

    @Override
    public VehicleMovement getMovementById(int id) {
    	    try {
    	        return repository.findById(id).get();
    	    } catch (Exception e) {
    	        throw new RuntimeException("Vehicle movement not found with ID: " + id);
    	    }
    	}

    @Override
    public List<VehicleMovement> getMovementByVehicleId(int vehicleId) {
        return repository.findByVehicleId(vehicleId);
    }
}
