package com.example.parking_lot.vehicle.impl;

import com.example.parking_lot.enums.VehicleType;
import com.example.parking_lot.vehicle.Vehicle;

public class Truck extends Vehicle {
    public Truck(String licenseNumber) {
        super(licenseNumber, VehicleType.TRUCK);
    }
}