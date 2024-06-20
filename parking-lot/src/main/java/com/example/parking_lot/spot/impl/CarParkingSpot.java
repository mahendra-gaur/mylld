package com.example.parking_lot.spot.impl;

import com.example.parking_lot.enums.ParkingSpotType;
import com.example.parking_lot.spot.ParkingSpot;
import lombok.Getter;

@Getter
public class CarParkingSpot extends ParkingSpot {
    public CarParkingSpot(String id) {
        super(id, ParkingSpotType.CAR);
    }
}