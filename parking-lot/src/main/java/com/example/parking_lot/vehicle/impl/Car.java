package com.example.parking_lot.vehicle.impl;

import com.example.parking_lot.enums.VehicleType;
import com.example.parking_lot.vehicle.Vehicle;

public class Car extends Vehicle {
    public Car(String licenseNumber) {
        super(licenseNumber, VehicleType.CAR);
    }
}