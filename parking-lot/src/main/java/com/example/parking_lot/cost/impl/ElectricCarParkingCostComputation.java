package com.example.parking_lot.cost.impl;

import com.example.parking_lot.cost.CostComputation;
import com.example.parking_lot.ticket.ParkingCharges;

public class ElectricCarParkingCostComputation implements CostComputation {

    private double baseCharge = 200;
    @Override
    public double getBaseCost() {
        return this.baseCharge;
    }
}
