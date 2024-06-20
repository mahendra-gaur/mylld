package com.example.parking_lot.ticket;

import com.example.parking_lot.enums.VehicleType;
import com.example.parking_lot.spot.ParkingSpot;
import com.example.parking_lot.vehicle.Vehicle;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
public class ParkingTicket {
    private final String id;
    private final LocalDateTime issuedAt;
    @Setter
    private LocalDateTime vacatedAt;
    private final Vehicle assignedVehicle;
    private final ParkingSpot allocatedSpot;
//    private double charge;
    private ParkingCharges charges;


}