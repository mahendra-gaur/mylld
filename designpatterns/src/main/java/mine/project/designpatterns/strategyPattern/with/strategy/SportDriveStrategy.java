package mine.project.designpatterns.strategyPattern.with.strategy;

public class SportDriveStrategy implements IDriveStrategy{
    @Override
    public void drive() {
        System.out.println("Sports drive capability");
    }
}
