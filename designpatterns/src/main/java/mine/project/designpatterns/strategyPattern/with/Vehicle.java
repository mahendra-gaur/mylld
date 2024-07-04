package mine.project.designpatterns.strategyPattern.with;

import mine.project.designpatterns.strategyPattern.with.strategy.IDriveStrategy;

public class Vehicle {
    IDriveStrategy drive;

    // this is known as constructor injection
    Vehicle(IDriveStrategy obj) {
        this.drive = obj;
    }
    public void drive() {
        this.drive.drive();
    }
}
