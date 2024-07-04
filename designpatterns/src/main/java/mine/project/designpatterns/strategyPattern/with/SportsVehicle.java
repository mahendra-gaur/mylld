package mine.project.designpatterns.strategyPattern.with;

import mine.project.designpatterns.strategyPattern.with.strategy.SportDriveStrategy;

public class SportsVehicle extends Vehicle{
    public SportsVehicle() {
        super(new SportDriveStrategy());
    }
}
