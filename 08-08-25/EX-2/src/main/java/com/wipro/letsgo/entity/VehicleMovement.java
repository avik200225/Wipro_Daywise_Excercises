package com.wipro.letsgo.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "vehicle_movement")
public class VehicleMovement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "vehicle_id")
    private int vehicleId;
    @Column(name="latitude")
    private double  lat;
    @Column(name = "longitude")
    private double  lon;


    public VehicleMovement() {}

    public VehicleMovement(int id, int vehicleId, Double lat, Double lon) {
        this.id = id;
        this.vehicleId = vehicleId;
        this.lat = lat;
        this.lon = lon;
    }

    public int getId() {
        return id;
    }
    public void setId(int d) {
        this.id = d;
    }

    public int getVehicleId() {
        return vehicleId;
    }
    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public double getLat() {
        return lat;
    }
    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }
    public void setLon(double lon) {
        this.lon = lon;
    }
}
