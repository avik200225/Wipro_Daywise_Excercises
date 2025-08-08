package com.wipro.letsgo.service;

import com.wipro.letsgo.entity.VehicleMovement;
import java.util.List;

public interface VehicleMovementService {
    VehicleMovement saveMovement(VehicleMovement movement);
    List<VehicleMovement> getAllMovements();
    VehicleMovement getMovementById(int id);
    List<VehicleMovement> getMovementByVehicleId(int vehicleId);
}
