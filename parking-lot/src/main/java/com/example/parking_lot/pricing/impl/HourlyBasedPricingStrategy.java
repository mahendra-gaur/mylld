package com.example.parking_lot.pricing.impl;

import com.example.parking_lot.pricing.PricingStrategy;
import com.example.parking_lot.ticket.ParkingTicket;
import java.time.Duration;

public class HourlyBasedPricingStrategy implements PricingStrategy {
    private static final double PRICE_PER_HOUR = 1.0;
    @Override
    public double calculateAmountCharged(final ParkingTicket parkingTicket) {
        final long hoursParked = Duration.between(parkingTicket.getIssuedAt(), parkingTicket.getVacatedAt()).toHours();
        double hourlyCost = PRICE_PER_HOUR + hoursParked > 0 ? (hoursParked - 1) * PRICE_PER_HOUR : 0;
        return hourlyCost + parkingTicket.getCharges().getBaseAmount();
    }
}