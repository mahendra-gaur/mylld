package mine.project.designpatterns.commandDesignPattern.invoker;

import mine.project.designpatterns.commandDesignPattern.command.ICommand;

public class RemoteControl {
    // Point 1 :-
    // Here we can have single object reference of ICommand and setter method to set this.
    // But this violet the rule which says - we should have as much immutable class as possible
    // so that we can define the boundary of a class.
    // If we have list of ICommand then it make sense to use the setter method to add the element of the list.
    // In this case we will make our list as immutable rather than the making the object immutable that list is storing.

    private final ICommand acOnCommand;
    private final ICommand acOffCommand;

    public RemoteControl(ICommand acOn, ICommand acOff) {
        this.acOnCommand = acOn;
        this.acOffCommand = acOff;
    }

    public void turnAcOn() {
            this.acOnCommand.execute();
        }

    public void undoTurnAcOn() {
        this.acOnCommand.undoExecute();
    }

    public void turnAcOff() {
        this.acOffCommand.execute();
    }

    public void undoTurnAcOff() {
        this.acOffCommand.undoExecute();
    }

}
