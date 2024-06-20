package com.example.parking_lot.spot.impl;

import com.example.parking_lot.enums.ParkingSpotType;
import com.example.parking_lot.spot.ParkingSpot;
import lombok.Getter;

@Getter
public class LargeParkingSpot extends ParkingSpot {
    public LargeParkingSpot(String id) {
        super(id, ParkingSpotType.LARGE);
    }
}