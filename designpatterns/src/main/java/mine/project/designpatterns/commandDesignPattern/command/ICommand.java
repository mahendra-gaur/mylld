package mine.project.designpatterns.commandDesignPattern.command;

public interface ICommand {
    // Point 2 :-
    // here we can have only one execute() method but then we won't be able to support the undo operation
    // this about the case where we have performed the 10 commands on any receiver and then we want to undo the last command.
    // If we have unexecute() command then we can undo the last command.
    void execute();
    void undoExecute();
}
