package mine.project.designpatterns.commandDesignPattern.command.impl;

import mine.project.designpatterns.commandDesignPattern.command.ICommand;
import mine.project.designpatterns.commandDesignPattern.receiver.AirConditioner;

public class TurnAcOffCommand implements ICommand {

    private final AirConditioner airConditioner;

    public TurnAcOffCommand(AirConditioner airConditioner) {
        this.airConditioner = airConditioner;
    }

    @Override
    public void execute() {
        this.airConditioner.turnOffAc();
    }

    @Override
    public void undoExecute() {
        this.airConditioner.turnOnAc();
    }
}
