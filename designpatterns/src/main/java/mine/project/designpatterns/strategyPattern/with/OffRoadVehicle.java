package mine.project.designpatterns.strategyPattern.with;

import mine.project.designpatterns.strategyPattern.with.strategy.SportDriveStrategy;

public class OffRoadVehicle extends Vehicle{
    public OffRoadVehicle() {
        super(new SportDriveStrategy());
    }
}
