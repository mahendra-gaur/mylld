package com.example.parking_lot.vehicle.impl;

import com.example.parking_lot.enums.VehicleType;
import com.example.parking_lot.vehicle.Vehicle;

public class Motorbike extends Vehicle {
    public Motorbike(String licenseNumber) {
        super(licenseNumber, VehicleType.MOTORBIKE);
    }
}