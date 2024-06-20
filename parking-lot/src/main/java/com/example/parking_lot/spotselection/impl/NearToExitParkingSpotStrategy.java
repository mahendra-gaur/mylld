package com.example.parking_lot.spotselection.impl;

import com.example.parking_lot.enums.VehicleType;
import com.example.parking_lot.exceptions.InvalidParkingFloorException;
import com.example.parking_lot.spotselection.ParkingSpotStrategy;
import com.example.parking_lot.spot.ParkingSpot;
import com.example.parking_lot.vehicle.Vehicle;
import java.util.Optional;

public class NearToExitParkingSpotStrategy implements ParkingSpotStrategy {

    @Override
    public boolean addParkingSpot(ParkingSpot parkingSpot) {
        return false;
    }

    @Override
    public ParkingSpot getParkingSpot(Vehicle vehicle) throws InvalidParkingFloorException {
        return null;
    }

    @Override
    public Optional<ParkingSpot> vacateParkingSpot(String parkingSpotId) {
        return Optional.empty();
    }

    @Override
    public boolean canPark(VehicleType vehicleType) {
        return false;
    }

}
