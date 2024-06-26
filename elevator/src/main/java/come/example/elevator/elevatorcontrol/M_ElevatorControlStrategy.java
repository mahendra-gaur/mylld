package come.example.elevator.ele4mine.elevatorcontrol;

import come.example.elevator.M_Direction;
import come.example.elevator.M_ElevatorController;

public interface M_ElevatorControlStrategy {
    void moveElevator(int floor, M_Direction direction, M_ElevatorController elevatorController);
}
