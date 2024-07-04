package mine.project.designpatterns.strategyPattern.with;

import mine.project.designpatterns.strategyPattern.with.strategy.NormalDriveStrategy;

public class PassengerVehicle extends Vehicle{
    public PassengerVehicle() {
        super(new NormalDriveStrategy());
    }
}
