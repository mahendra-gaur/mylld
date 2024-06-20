package com.example.parking_lot.vehicle;

import com.example.parking_lot.enums.VehicleType;
import com.example.parking_lot.ticket.ParkingTicket;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public abstract class Vehicle {
    private final String licenseNumber;
    private final VehicleType vehicleType;
    private ParkingTicket parkingTicket;

    public Vehicle(String licenseNumber, VehicleType vehicleType) {
        this.licenseNumber = licenseNumber;
        this.vehicleType = vehicleType;
    }

    public void assignTicket(ParkingTicket parkingTicket){
        this.parkingTicket=parkingTicket;
    }
}