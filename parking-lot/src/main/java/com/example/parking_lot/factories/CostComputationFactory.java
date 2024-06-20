package com.example.parking_lot.factories;

import com.example.parking_lot.cost.CostComputation;
import com.example.parking_lot.cost.impl.CarParkingCostComputation;
import com.example.parking_lot.cost.impl.ElectricCarParkingCostComputation;
import com.example.parking_lot.cost.impl.LargeParkingCostComputation;
import com.example.parking_lot.cost.impl.MotorbikeParkingCostComputation;
import com.example.parking_lot.enums.VehicleType;
import com.example.parking_lot.vehicle.impl.Truck;

public class CostComputationFactory {

    public static CostComputation getCostComputationForVehicle(VehicleType vehicleType) {
        switch (vehicleType) {
            case CAR -> {
                return new CarParkingCostComputation();
            }
            case ELECTRIC_CAR -> {
                return new ElectricCarParkingCostComputation();
            }
            case MOTORBIKE -> {
                return new MotorbikeParkingCostComputation();
            }
            default -> {
                return new LargeParkingCostComputation();
            }
        }
    }

}
