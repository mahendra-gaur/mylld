package com.example.parking_lot.panel;

import com.example.parking_lot.exceptions.InvalidParkingFloorException;
import com.example.parking_lot.exceptions.ParkingFullException;
import com.example.parking_lot.parkinglot.ParkingLot;
import com.example.parking_lot.spot.ParkingSpot;
import com.example.parking_lot.ticket.ParkingTicket;
import com.example.parking_lot.vehicle.Vehicle;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class EntryPanel {
    private final String id;

    public ParkingTicket getTicket(final Vehicle vehicle) throws ParkingFullException, InvalidParkingFloorException {
        final ParkingSpot parkingSpot = ParkingLot.getInstance().getParkingSpot(vehicle);
        return buildParkingTicket(vehicle, parkingSpot);
    }

    private ParkingTicket buildParkingTicket(Vehicle vehicle, ParkingSpot parkingSpot) {
        return ParkingTicket.builder()
                .id(UUID.randomUUID().toString())
                .issuedAt(LocalDateTime.now())
                .assignedVehicle(vehicle)
                .allocatedSpot(parkingSpot)
                .build();
    }

}