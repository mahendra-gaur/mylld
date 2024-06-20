package com.example.parking_lot.account;

import com.example.parking_lot.exceptions.InvalidParkingFloorException;
import com.example.parking_lot.exceptions.ParkingFullException;
import com.example.parking_lot.panel.EntryPanel;
import com.example.parking_lot.panel.ExitPanel;
import com.example.parking_lot.ticket.ParkingTicket;
import com.example.parking_lot.vehicle.Vehicle;

public class Attender extends Account {

    private EntryPanel entryPanel;
    private ExitPanel exitPanel;

    public ParkingTicket getParkingTicket(Vehicle vehicle) {
        ParkingTicket parkingTicket = null;
        try {
            parkingTicket = entryPanel.getTicket(vehicle);
        } catch (ParkingFullException e) {
            System.out.println("Parking is full");
        } catch (InvalidParkingFloorException e) {
            System.out.println("System error - Invalid parking floor");
        }
        return parkingTicket;
    }

    public void vacateParking(ParkingTicket parkingTicket) {
        exitPanel.scanAndVacate(parkingTicket);
    }

}
