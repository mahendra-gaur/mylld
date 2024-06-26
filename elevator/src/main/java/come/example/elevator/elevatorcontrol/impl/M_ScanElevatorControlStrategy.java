package come.example.elevator.ele4mine.elevatorcontrol.impl;

import come.example.elevator.M_Direction;
import come.example.elevator.M_ElevatorController;
import come.example.elevator.ele4mine.elevatorcontrol.M_ElevatorControlStrategy;

public class M_ScanElevatorControlStrategy implements M_ElevatorControlStrategy {

    @Override
    public void moveElevator(int floor, M_Direction direction, M_ElevatorController elevatorController) {
//        In this algorithm, elevator starts from one end of the disk and moves
//        towards the other end, servicing requests in between one by one and reach the other end.
//        Then the direction of the elevator is reversed and the process continues.

//        Implemented using two array
//        All floors with UP requests are marked in the UP array
//        and all floors with DOWN request are marked in the DOWN array
//        and the elevator scans UP array while moving up and DOWN array while moving down
//        and it stops at the requested floors

//        Advantage:
//        1. not frequent change of floor for every request
//        2. no starvation

//        Disadvantage: If there are 100 floors, and last requested floor in current direction
//        is 15, then also the elevator will move till the 100th floor.
//        This is improved by LOOK Algorithm
        elevatorController.getElevatorCar().move(direction, floor);
    }
}
