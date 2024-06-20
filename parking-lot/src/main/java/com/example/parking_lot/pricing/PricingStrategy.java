package com.example.parking_lot.pricing;

import com.example.parking_lot.ticket.ParkingTicket;

public interface PricingStrategy {
    double calculateAmountCharged(ParkingTicket parkingTicket);
}