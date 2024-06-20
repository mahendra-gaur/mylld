package com.example.parking_lot.vehicle.impl;

import com.example.parking_lot.enums.VehicleType;
import com.example.parking_lot.vehicle.Vehicle;

public class ElectricCar extends Vehicle {
    public ElectricCar(String licenseNumber) {
        super(licenseNumber, VehicleType.ELECTRIC_CAR);
    }
}