package com.example.parking_lot.spotselection.impl;

import com.example.parking_lot.enums.ParkingSpotType;
import com.example.parking_lot.enums.VehicleType;
import com.example.parking_lot.exceptions.InvalidParkingFloorException;
import com.example.parking_lot.spotselection.ParkingSpotStrategy;
import com.example.parking_lot.spot.ParkingSpot;
import com.example.parking_lot.vehicle.Vehicle;
import java.util.Deque;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentMap;

public class DefaultParkingSpotStrategy implements ParkingSpotStrategy {

    private final ConcurrentMap<ParkingSpotType, Deque<ParkingSpot>> parkingSpots;
    private final ConcurrentMap<String, ParkingSpot> usedParkingSpots;

    public DefaultParkingSpotStrategy() {
        parkingSpots = new ConcurrentHashMap<>();
        usedParkingSpots = new ConcurrentHashMap<>();
        parkingSpots.put(ParkingSpotType.CAR, new ConcurrentLinkedDeque<>());
        parkingSpots.put(ParkingSpotType.LARGE, new ConcurrentLinkedDeque<>());
        parkingSpots.put(ParkingSpotType.MOTORBIKE, new ConcurrentLinkedDeque<>());
        parkingSpots.put(ParkingSpotType.ELECTRIC_CAR, new ConcurrentLinkedDeque<>());
    }

    @Override
    public boolean addParkingSpot(final ParkingSpot parkingSpot) {
        final Optional<ParkingSpot> spot = parkingSpots.get(parkingSpot.getParkingSpotType())
                .stream()
                .filter(pS -> pS.getId().equals(parkingSpot.getId()))
                .findAny();
        if (spot.isPresent()) {
            return false;
        }
        parkingSpots.get(parkingSpot.getParkingSpotType()).add(parkingSpot);
        return true;
    }

    @Override
    public synchronized ParkingSpot getParkingSpot(final Vehicle vehicle) throws InvalidParkingFloorException {
        final ParkingSpotType parkingSpotType =
                ParkingSpotType.getParkingSpotTypeForVehicle(vehicle.getVehicleType());
        if (!canPark(parkingSpotType)) {
            throw new InvalidParkingFloorException("Cannot Find a spot");
        }
        final ParkingSpot parkingSpot = parkingSpots.get(parkingSpotType).poll();
        parkingSpot.assignVehicle(vehicle);
        usedParkingSpots.put(parkingSpot.getId(), parkingSpot);
        return parkingSpot;
    }

    @Override
    public boolean canPark(final VehicleType vehicleType) {
        return parkingSpots.get(ParkingSpotType.getParkingSpotTypeForVehicle(vehicleType)).size() > 0;
    }


    private boolean canPark(final ParkingSpotType parkingSpotTypeForVehicle) {
        return parkingSpots.get(parkingSpotTypeForVehicle).size() > 0;
    }

    @Override
    public Optional<ParkingSpot> vacateParkingSpot(String parkingSpotId) {
        final ParkingSpot parkingSpot = usedParkingSpots.get(parkingSpotId);
        if (Objects.nonNull(parkingSpot)) {
            parkingSpot.vacateSpot();
            parkingSpots.get(parkingSpot.getParkingSpotType()).addFirst(parkingSpot);
        }
        return Optional.ofNullable(parkingSpot);
    }


}
