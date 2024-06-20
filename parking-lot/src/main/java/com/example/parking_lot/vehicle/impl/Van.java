package com.example.parking_lot.vehicle.impl;

import com.example.parking_lot.enums.VehicleType;
import com.example.parking_lot.vehicle.Vehicle;

public class Van extends Vehicle {
    public Van(String licenseNumber) {
        super(licenseNumber, VehicleType.VAN);
    }
}