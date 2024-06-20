package com.example.parking_lot.spotselection;

import com.example.parking_lot.enums.VehicleType;
import com.example.parking_lot.exceptions.InvalidParkingFloorException;
import com.example.parking_lot.spot.ParkingSpot;
import com.example.parking_lot.vehicle.Vehicle;
import java.util.Optional;

public interface ParkingSpotStrategy {
    boolean addParkingSpot(final ParkingSpot parkingSpot);
    ParkingSpot getParkingSpot(final Vehicle vehicle) throws InvalidParkingFloorException;
    Optional<ParkingSpot> vacateParkingSpot(final String parkingSpotId);
    boolean canPark(final VehicleType vehicleType);

}
