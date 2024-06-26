package come.example.elevator;

public class M_Floor {
    private int floorNumber;
    private M_ExternalButton externalButton;

    public M_Floor(int floorNumber) {
        this.floorNumber = floorNumber;
        this.externalButton = new M_ExternalButton();
    }

    public void pressUp(){
        this.externalButton.pressButton(this.floorNumber, M_Direction.UP);
    }

    public void pressDown(){
        this.externalButton.pressButton(this.floorNumber, M_Direction.DOWN);
    }
}
