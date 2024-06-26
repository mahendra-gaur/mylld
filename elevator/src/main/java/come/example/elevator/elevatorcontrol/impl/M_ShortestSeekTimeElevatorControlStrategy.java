package come.example.elevator.ele4mine.elevatorcontrol.impl;

import come.example.elevator.M_Direction;
import come.example.elevator.M_ElevatorController;
import come.example.elevator.ele4mine.elevatorcontrol.M_ElevatorControlStrategy;

public class M_ShortestSeekTimeElevatorControlStrategy implements M_ElevatorControlStrategy {

    @Override
    public void moveElevator(int floor, M_Direction direction, M_ElevatorController elevatorController) {
//implemented using min heap which is sorted according to
        //min distance of requested floor from the current floor of elevator

        //this min heap is updated everytime a new request is added in the queue or
        // when elevator moves to another floor

        //Disadvantage: starvation of distant floor when maximum request keeps comes from nearly floors

        elevatorController.getElevatorCar().move(direction, floor);
    }
}
