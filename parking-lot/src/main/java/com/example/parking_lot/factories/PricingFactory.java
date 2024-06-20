package com.example.parking_lot.factories;

import com.example.parking_lot.enums.PricingStrategyType;
import com.example.parking_lot.pricing.PricingStrategy;
import com.example.parking_lot.pricing.impl.HourlyBasedPricingStrategy;
import com.example.parking_lot.pricing.impl.MinuteBasedPricingStrategy;

public class PricingFactory {

    public static PricingStrategy getPricingStrategy(PricingStrategyType pricingStrategyType) {
        switch (pricingStrategyType) {
            case HOURLY -> {
                return new HourlyBasedPricingStrategy();
            }case MINUTES -> {
                return new MinuteBasedPricingStrategy();
            }default -> {
                return new HourlyBasedPricingStrategy();
            }
        }
    }

}
