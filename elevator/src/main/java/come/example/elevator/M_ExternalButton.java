package come.example.elevator;

public class M_ExternalButton {
    private M_ExternalButtonDispatcher externalButtonDispatcher;

    public M_ExternalButton(){
        this.externalButtonDispatcher = new M_ExternalButtonDispatcher();
    }

    public void pressButton(int floor, M_Direction direction){
        this.externalButtonDispatcher.pressButton(floor, direction);
    }

}
