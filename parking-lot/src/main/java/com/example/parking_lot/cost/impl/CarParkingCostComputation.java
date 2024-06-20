package com.example.parking_lot.cost.impl;

import com.example.parking_lot.cost.CostComputation;
import com.example.parking_lot.ticket.ParkingCharges;

public class CarParkingCostComputation implements CostComputation {

    private double baseCharge = 100;
    @Override
    public double getBaseCost() {
        return this.baseCharge;
    }
}
