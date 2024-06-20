package com.example.parking_lot.enums;

public enum ParkingSpotType {
    CAR,
    ELECTRIC_CAR,
    LARGE,
    MOTORBIKE;

    public static ParkingSpotType getParkingSpotTypeForVehicle(final VehicleType vehicleType) {
        switch (vehicleType) {
            case CAR:
                return CAR;
            case ELECTRIC_CAR:
                return ELECTRIC_CAR;
            case MOTORBIKE:
                return MOTORBIKE;
            case TRUCK:
                return LARGE;
            case VAN:
                return LARGE;
            default:
                return LARGE;
        }
    }
}