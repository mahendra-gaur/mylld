package come.example.elevator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class M_InternalButtons {

    private M_InternalButtonDispatcher internalButtonDispatcher;
    private List<Integer> floors;

    public M_InternalButtons(int startFloor, int endFloor) {
        this.floors = new ArrayList<>();
        IntStream.rangeClosed(startFloor, endFloor).mapToObj(this.floors::add);
        this.internalButtonDispatcher = new M_InternalButtonDispatcher();
    }

    public void pressButton(int floor, int elevatorCarId) {
        // validate the floor - it must be one from floors list and then submit it to dispatcher
        this.internalButtonDispatcher.submitRequest(floor, elevatorCarId);
    }

}
