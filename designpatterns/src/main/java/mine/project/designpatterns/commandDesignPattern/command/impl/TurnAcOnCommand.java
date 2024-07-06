package mine.project.designpatterns.commandDesignPattern.command.impl;

import mine.project.designpatterns.commandDesignPattern.command.ICommand;
import mine.project.designpatterns.commandDesignPattern.receiver.AirConditioner;

public class TurnAcOnCommand implements ICommand {

    private final AirConditioner airConditioner;

    public TurnAcOnCommand(AirConditioner airConditioner) {
        this.airConditioner = airConditioner;
    }

    @Override
    public void execute() {
        this.airConditioner.turnOnAc();
    }

    @Override
    public void undoExecute() {
        this.airConditioner.turnOffAc();
    }
}

