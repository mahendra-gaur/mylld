package come.example.elevator.ele4mine.elevatorselection;

import come.example.elevator.M_Direction;
import come.example.elevator.M_ElevatorController;
import java.util.List;

public interface M_ElevatorSelectionStrategy {
    M_ElevatorController selectElevator(int floor, M_Direction dir, List<M_ElevatorController> elevatorControllerList);
}
