package come.example.elevator;

import java.util.List;

public class M_InternalButtonDispatcher extends M_ButtonDispatcher {

    public M_InternalButtonDispatcher() {
        super(M_ElevatorCreator.elevatorControllerList);
    }

    public void submitRequest(int floor, int elevatorCarId) {
        // get the correct ElevatorController from elevatorControllerList using elevatorCarId and
        // submit the request to ElevatorController
        M_ElevatorController elevatorController = this.getElevatorControllerUsingElevatorCarId(elevatorCarId);
        elevatorController.submitRequest(floor);
    }

    public M_ElevatorController getElevatorControllerUsingElevatorCarId(int elevatorCarId) {
        return this.getElevatorControllerList().get(0);
    }
}
