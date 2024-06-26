package come.example.elevator;


public class M_Display {
    int floor;
    M_Direction direction;

    public void setDisplay(int floor, M_Direction direction) {
        this.floor = floor;
        this.direction = direction;
    }

    @Override
    public String toString() {
        return "M_Display{" + "floor=" + floor + ", direction=" + direction + "}";
    }
}
