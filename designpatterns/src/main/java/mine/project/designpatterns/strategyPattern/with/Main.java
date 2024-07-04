package mine.project.designpatterns.strategyPattern.with;

public class Main {

    public static void main(String[] args) {
        System.out.println("----------------sport vehicle------------------");
        Vehicle sportsVehicle = new SportsVehicle();
        sportsVehicle.drive();
        System.out.println("-----------------------------------------------");

        System.out.println();

        System.out.println("--------------Passenger vehicle----------------");
        Vehicle passengerVehicle = new PassengerVehicle();
        passengerVehicle.drive();
        System.out.println("-----------------------------------------------");

        System.out.println();

        System.out.println("---------------OffRoad vehicle-----------------");
        Vehicle offRoadVehicle = new OffRoadVehicle();
        offRoadVehicle.drive();
        System.out.println("-----------------------------------------------");


    }
}
