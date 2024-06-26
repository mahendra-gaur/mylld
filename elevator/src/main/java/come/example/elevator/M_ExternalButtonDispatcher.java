package come.example.elevator;

import come.example.elevator.ele4mine.elevatorselection.M_ElevatorSelectionStrategy;
import come.example.elevator.ele4mine.elevatorselection.impl.M_OddEvenElevatorSelectionStrategy;

public class M_ExternalButtonDispatcher extends M_ButtonDispatcher {

    private M_ElevatorSelectionStrategy elevatorSelectionStrategy;
    public M_ExternalButtonDispatcher() {
        super(M_ElevatorCreator.elevatorControllerList);
        this.elevatorSelectionStrategy = new M_OddEvenElevatorSelectionStrategy();
    }

    public void pressButton(int floor, M_Direction direction){
        M_ElevatorController elevatorController = this.getElevatorControllerToServeRequest(floor, direction);
        elevatorController.submitRequest(floor, direction);

    }

    private M_ElevatorController getElevatorControllerToServeRequest(int floor, M_Direction direction) {

        return this.elevatorSelectionStrategy.selectElevator(floor, direction, this.getElevatorControllerList());
    }
}

