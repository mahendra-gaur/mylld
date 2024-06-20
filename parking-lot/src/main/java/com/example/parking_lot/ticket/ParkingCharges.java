package com.example.parking_lot.ticket;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
public class ParkingCharges {

    private double baseAmount;
    private double totalAmount;
    private double taxAmount;

}
