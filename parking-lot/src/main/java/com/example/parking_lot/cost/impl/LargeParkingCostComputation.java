package com.example.parking_lot.cost.impl;

import com.example.parking_lot.cost.CostComputation;
import com.example.parking_lot.ticket.ParkingCharges;

public class LargeParkingCostComputation implements CostComputation {

    private double baseCharge = 150;
    @Override
    public double getBaseCost() {
        return this.baseCharge;
    }
}
