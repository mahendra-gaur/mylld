package come.example.elevator;

import java.util.ArrayList;
import java.util.List;

public class M_ElevatorCreator {

    public static List<M_ElevatorController> elevatorControllerList = new ArrayList<>();
    static {
        M_ElevatorCar elevatorCar_1 = new M_ElevatorCar(1,1,20);
        M_ElevatorController elevatorController_1 = new M_ElevatorController();
        elevatorController_1.setElevatorCar(elevatorCar_1);
        elevatorControllerList.add(elevatorController_1);

        M_ElevatorCar elevatorCar_2 = new M_ElevatorCar(2,1,20);
        M_ElevatorController elevatorController_2 = new M_ElevatorController();
        elevatorController_2.setElevatorCar(elevatorCar_2);
        elevatorControllerList.add(elevatorController_2);

        M_ElevatorCar elevatorCar_3 = new M_ElevatorCar(3,1,20);
        M_ElevatorController elevatorController_3 = new M_ElevatorController();
        elevatorController_3.setElevatorCar(elevatorCar_3);
        elevatorControllerList.add(elevatorController_3);
    }

}
