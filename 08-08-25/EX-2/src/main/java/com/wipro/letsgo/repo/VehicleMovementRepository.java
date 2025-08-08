package com.wipro.letsgo.repo;
import com.wipro.letsgo.entity.VehicleMovement;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleMovementRepository extends JpaRepository<VehicleMovement, Integer> {
	List<VehicleMovement> findByVehicleId(int vehicleId);
}
