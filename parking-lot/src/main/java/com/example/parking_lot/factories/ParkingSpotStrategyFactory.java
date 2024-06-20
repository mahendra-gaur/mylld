package com.example.parking_lot.factories;

import com.example.parking_lot.enums.ParkingSpotStrategyType;
import com.example.parking_lot.spotselection.ParkingSpotStrategy;
import com.example.parking_lot.spotselection.impl.DefaultParkingSpotStrategy;
import com.example.parking_lot.spotselection.impl.NearToEntranceParkingSpotStrategy;
import com.example.parking_lot.spotselection.impl.NearToExitParkingSpotStrategy;

public class ParkingSpotStrategyFactory {
    public static ParkingSpotStrategy getParkingStrategy(ParkingSpotStrategyType parkingSpotStrategyType) {
        switch (parkingSpotStrategyType) {
            case NEAR_TO_EXIT -> {
                return new NearToExitParkingSpotStrategy();
            } case NEAR_TO_ENTRANCE -> {
                return new NearToEntranceParkingSpotStrategy();
            }default -> {
                return new DefaultParkingSpotStrategy();
            }
        }
    }

}
