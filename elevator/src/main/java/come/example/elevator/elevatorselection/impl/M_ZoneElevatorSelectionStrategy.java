package come.example.elevator.ele4mine.elevatorselection.impl;

import come.example.elevator.M_Direction;
import come.example.elevator.M_ElevatorController;
import come.example.elevator.ele4mine.elevatorselection.M_ElevatorSelectionStrategy;
import java.util.List;


public class M_ZoneElevatorSelectionStrategy implements M_ElevatorSelectionStrategy {

    @Override
    public M_ElevatorController selectElevator(int floor, M_Direction dir, List<M_ElevatorController> elevatorControllerList) {
//        for(ElevatorController eController: elevatorControllerList) {
//            assign elevators according to zones in building
//            out of these elevators select the elevator which is going in the same direction or is idle
//        }
//        return ThreadLocalRandom.current().nextInt(1, elevatorControllerList.size());
        return elevatorControllerList.get(0);
    }
}