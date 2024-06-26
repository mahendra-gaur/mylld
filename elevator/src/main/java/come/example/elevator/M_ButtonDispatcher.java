package come.example.elevator;

import java.util.List;
import lombok.Getter;

public abstract class M_ButtonDispatcher {
    @Getter
    private List<M_ElevatorController> elevatorControllerList;
    public M_ButtonDispatcher(List<M_ElevatorController> elevatorControllerList) {
        this.elevatorControllerList = elevatorControllerList;
    }
}
