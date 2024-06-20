package com.example.parking_lot.account;

import com.example.parking_lot.exceptions.InvalidParkingFloorException;
import com.example.parking_lot.exceptions.ParkingFullException;
import com.example.parking_lot.panel.EntryPanel;
import com.example.parking_lot.panel.ExitPanel;
import com.example.parking_lot.parkingfloor.ParkingFloor;
import com.example.parking_lot.parkinglot.ParkingLot;
import com.example.parking_lot.spot.ParkingSpot;
import com.example.parking_lot.vehicle.Vehicle;

public class Admin extends Account{
    private ParkingLot parkingLot;

    public void addFloor(final ParkingFloor parkingFloor) {
        parkingLot.addFloor(parkingFloor);
    }

    public void addEntryPanel(final EntryPanel entryPanel) {
        parkingLot.addEntryPanel(entryPanel);
    }

    public void addExitPanel(final ExitPanel exitPanel) {
        parkingLot.addExitPanel(exitPanel);
    }

    public void addParkingSpot(final String floorId, final ParkingSpot parkingSpot) throws InvalidParkingFloorException {
        parkingLot.addParkingSpot(floorId, parkingSpot);
    }

    public ParkingSpot getParkingSpot(final Vehicle vehicle) throws ParkingFullException, InvalidParkingFloorException {
        return parkingLot.getParkingSpot(vehicle);
    }

    public void vacateParkingSpot(final String parkingSpotId) {
        parkingLot.vacateParkingSpot(parkingSpotId);
    }

}