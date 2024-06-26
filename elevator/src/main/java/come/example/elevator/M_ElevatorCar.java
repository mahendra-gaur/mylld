package come.example.elevator;


import lombok.Getter;

public class M_ElevatorCar {
    @Getter
    private int id;
    @Getter
    private int currentFloor;
    private M_Direction currentDirection;
//    private M_ElevatorState currentState;
    private M_Display display;
    private M_InternalButtons internalButtons;
    private M_Door elevatorDoor;

    public M_ElevatorCar(int elevatorId, int startFloor, int endFloor) {
        this.id = elevatorId;
        this.currentFloor = 1;
        this.currentDirection = M_Direction.NONE;
//        this.currentState = M_ElevatorState.IDLE;
        this.display = new M_Display();
        this.internalButtons = new M_InternalButtons(startFloor, endFloor);
        this.elevatorDoor = new M_Door();
    }

    public void pressButton(int floor) {
        this.internalButtons.pressButton(floor, this.id);
    }

    public void setAndShowDisplay(int floor, M_Direction direction) {
        this.display.setDisplay(floor, direction);
        System.out.println(direction);
    }

    public boolean move(M_Direction dir, int destinationFloor){
        int startFloor = currentFloor;
        if(dir == M_Direction.UP) {
            for(int i = startFloor; i<=destinationFloor; i++) {
                this.currentFloor = startFloor;
                this.currentDirection = M_Direction.UP;
                setAndShowDisplay(this.currentFloor, this.currentDirection);
                if(i == destinationFloor) {
                    this.elevatorDoor.open();
                    this.elevatorDoor.close();
                    return true;
                }
            }
        }
        if(dir == M_Direction.DOWN) {
            for(int i = startFloor; i>=destinationFloor; i--) {
                this.currentFloor = startFloor;
                this.currentDirection = M_Direction.DOWN;
                setAndShowDisplay(this.currentFloor, this.currentDirection);
                if(i == destinationFloor) {
                    this.elevatorDoor.open();
                    this.elevatorDoor.close();
                    return true;
                }
            }
        }
        return false;
    }
}
