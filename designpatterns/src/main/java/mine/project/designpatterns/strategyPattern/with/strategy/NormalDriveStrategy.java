package mine.project.designpatterns.strategyPattern.with.strategy;

public class NormalDriveStrategy implements IDriveStrategy{
    @Override
    public void drive() {
        System.out.println("Normal drive capability");
    }
}
