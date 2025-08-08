package com.wipro.letsgo.controller;
import com.wipro.letsgo.entity.VehicleMovement;
import com.wipro.letsgo.service.VehicleMovementService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/move")
public class VehicleMovementController {

    @Autowired
	VehicleMovementService service;

    public VehicleMovementController(VehicleMovementService service) {
        this.service = service;
    }

    @PostMapping
    public VehicleMovement moveVehicle(@RequestBody VehicleMovement request) {
        VehicleMovement movement = new VehicleMovement();
        movement.setVehicleId(request.getVehicleId());
        movement.setLat(request.getLat());
        movement.setLon(request.getLon());
        return service.saveMovement(movement);
    }

    @GetMapping
    public List<VehicleMovement> getAllMovements() {
        return service.getAllMovements();
    }

    @GetMapping("/{vehicleId}")
    public List<VehicleMovement> getMovementByVehicleId(@PathVariable int vehicleId) {
        return service.getMovementByVehicleId(vehicleId);
    }
    
//  @GetMapping("/{id}")
//  public VehicleMovement getMovementById(@PathVariable int id) {
//      return service.getMovementById(id);
//  }
  
}

