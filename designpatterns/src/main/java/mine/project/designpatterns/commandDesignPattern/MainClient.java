package mine.project.designpatterns.commandDesignPattern;

import mine.project.designpatterns.commandDesignPattern.command.impl.TurnAcOffCommand;
import mine.project.designpatterns.commandDesignPattern.command.impl.TurnAcOnCommand;
import mine.project.designpatterns.commandDesignPattern.invoker.RemoteControl;
import mine.project.designpatterns.commandDesignPattern.receiver.AirConditioner;

public class MainClient {

    public static void main(String[] args) {
        AirConditioner ac = new AirConditioner(true, 20);
        TurnAcOnCommand turnAcOnCommand = new TurnAcOnCommand(ac);
        TurnAcOffCommand turnAcOffCommand = new TurnAcOffCommand(ac);
        RemoteControl remote = new RemoteControl(turnAcOnCommand, turnAcOffCommand);

        remote.turnAcOn();
        remote.undoTurnAcOn();
        remote.turnAcOff();
        remote.undoTurnAcOff();
    }
}
