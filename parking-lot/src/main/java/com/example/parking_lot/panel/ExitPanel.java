package com.example.parking_lot.panel;

import com.example.parking_lot.cost.CostComputation;
import com.example.parking_lot.enums.PricingStrategyType;
import com.example.parking_lot.factories.CostComputationFactory;
import com.example.parking_lot.factories.PricingFactory;
import com.example.parking_lot.parkinglot.ParkingLot;
import com.example.parking_lot.pricing.PricingStrategy;
import com.example.parking_lot.ticket.ParkingTicket;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ExitPanel {
    private final String id;

    private final PricingStrategyType pricingStrategyType;

    public void scanAndVacate(final ParkingTicket parkingTicket) {
        vacateParkingSpot(parkingTicket);
        calculateCharge(parkingTicket);
    }

    private void vacateParkingSpot(ParkingTicket parkingTicket) {
        ParkingLot.getInstance().vacateParkingSpot(parkingTicket.getAllocatedSpot().getId());
        parkingTicket.setVacatedAt(LocalDateTime.now());
    }

    private void calculateCharge(ParkingTicket parkingTicket) {
        CostComputation costComputation =
                CostComputationFactory.getCostComputationForVehicle(parkingTicket.getAssignedVehicle()
                        .getVehicleType());
        parkingTicket.getCharges().setBaseAmount(costComputation.getBaseCost());
        PricingStrategy pricingStrategy = PricingFactory.getPricingStrategy(pricingStrategyType);
        parkingTicket.getCharges().setTotalAmount(pricingStrategy.calculateAmountCharged(parkingTicket));
    }
}