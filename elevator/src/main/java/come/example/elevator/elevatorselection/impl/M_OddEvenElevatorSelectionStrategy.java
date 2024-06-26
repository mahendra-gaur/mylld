package come.example.elevator.ele4mine.elevatorselection.impl;

import come.example.elevator.M_Direction;
import come.example.elevator.M_ElevatorController;
import come.example.elevator.ele4mine.elevatorselection.M_ElevatorSelectionStrategy;
import java.util.List;

public class M_OddEvenElevatorSelectionStrategy implements M_ElevatorSelectionStrategy {

    @Override
    public M_ElevatorController selectElevator(int floor, M_Direction dir, List<M_ElevatorController> elevatorControllerList) {
//          old elevator for odd floors and even elevators for even floors
//          select elevator which is moving in same direction which is requested or IDLE elevator
//        if(floor%2 == eController.getId()%2)
//        {
//            int currFloor= eController.getElevatorCar().getCurrentFloor();
//            Direction currDir= eController.getElevatorCar().getElevatorDirection();
//            if(floor>currFloor && currDir==Direction.UP)
//                return eController.getId();
//            else if(floor<currFloor && currDir==Direction.DOWN)
//                return eController.getId();
//            else if(currDir==Direction.NONE)
//                return eController.getId();
//
//        }
//    }
//        return ThreadLocalRandom.current().nextInt(1, elevatorControllerList.size());
        return elevatorControllerList.get(0);
    }
}
