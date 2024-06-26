package come.example.elevator;

import come.example.elevator.ele4mine.elevatorcontrol.M_ElevatorControlStrategy;
import come.example.elevator.ele4mine.elevatorcontrol.impl.M_ScanElevatorControlStrategy;
import lombok.Getter;
import lombok.Setter;

public class M_ElevatorController {

    @Setter
    @Getter
    private M_ElevatorCar elevatorCar;

    @Setter
    private M_ElevatorControlStrategy elevatorControlStrategy;

    public M_ElevatorController() {
        this.elevatorControlStrategy = new M_ScanElevatorControlStrategy();
    }

    public void submitRequest(int floor){
        M_Direction direction = M_Direction.NONE;
        if(floor>this.elevatorCar.getCurrentFloor())
            direction = M_Direction.UP;
        else if(floor<this.elevatorCar.getCurrentFloor())
            direction = M_Direction.DOWN;
        this.submitRequest(floor, direction);
    }

    public void submitRequest(int floor, M_Direction direction){
        this.elevatorControlStrategy.moveElevator(floor, direction, this);
    }

}
