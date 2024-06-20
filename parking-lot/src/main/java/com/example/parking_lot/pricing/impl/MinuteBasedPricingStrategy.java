package com.example.parking_lot.pricing.impl;

import com.example.parking_lot.pricing.PricingStrategy;
import com.example.parking_lot.ticket.ParkingTicket;
import java.time.Duration;

public class MinuteBasedPricingStrategy implements PricingStrategy {
    private static final double PRICE_PER_HOUR = 1.0;

    @Override
    public double calculateAmountCharged(final ParkingTicket parkingTicket) {
        final long minutesParked =
                Duration.between(parkingTicket.getIssuedAt(), parkingTicket.getVacatedAt()).toMinutes();
        double minuteCost = PRICE_PER_HOUR + minutesParked > 0 ? (minutesParked - 1) * PRICE_PER_HOUR : 0;
        return minuteCost + parkingTicket.getCharges().getBaseAmount();
    }
}