package mine.project.designpatterns.commandDesignPattern.receiver;

public class AirConditioner {
    private Boolean isOn;
    private Integer tempreture;

    public AirConditioner(final Boolean isOn, final Integer tempreture) {
        this.isOn = isOn;
        this.tempreture = tempreture;
    }

    public void turnOnAc() {
        this.isOn = true;
        System.out.println("AC is ON");
    }

    public void turnOffAc() {
        this.isOn = false;
        System.out.println("AC is OFF");
    }

    public void setTempreture(final Integer tempreture) {
        this.tempreture = tempreture;
    }

}
