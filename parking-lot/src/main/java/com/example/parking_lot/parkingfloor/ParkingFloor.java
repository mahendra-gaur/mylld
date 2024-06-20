package com.example.parking_lot.parkingfloor;

import com.example.parking_lot.enums.ParkingSpotStrategyType;
import com.example.parking_lot.enums.VehicleType;
import com.example.parking_lot.exceptions.InvalidParkingFloorException;
import com.example.parking_lot.factories.ParkingSpotStrategyFactory;
import com.example.parking_lot.spotselection.ParkingSpotStrategy;
import com.example.parking_lot.spot.ParkingSpot;
import com.example.parking_lot.vehicle.Vehicle;
import java.util.Optional;
import lombok.Getter;

public class ParkingFloor {
    @Getter
    private final String id;
    private final ParkingSpotStrategy parkingSpotStrategy;

    public ParkingFloor(String id, final ParkingSpotStrategyType parkingSpotStrategyType) {
        this.id = id;
        this.parkingSpotStrategy = ParkingSpotStrategyFactory.getParkingStrategy(parkingSpotStrategyType);
    }

    public boolean addParkingSpot(final ParkingSpot parkingSpot) {
        return this.parkingSpotStrategy.addParkingSpot(parkingSpot);
    }

    public synchronized ParkingSpot getParkingSpot(final Vehicle vehicle) throws InvalidParkingFloorException {
        return this.parkingSpotStrategy.getParkingSpot(vehicle);
    }

    public Optional<ParkingSpot> vacateParkingSpot(final String parkingSpotId) {
        return this.parkingSpotStrategy.vacateParkingSpot(parkingSpotId);
    }

    public boolean canPark(final VehicleType vehicleType) {
        return this.parkingSpotStrategy.canPark(vehicleType);
    }

}