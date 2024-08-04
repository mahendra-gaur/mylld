package com.craft.command;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CommandInvoker {
    private List<Command> commandList = new ArrayList<>();

    public void addCommand(Command command) {
        commandList.add(command);
    }

    public void executeCommands() {
        for (Command command : commandList) {
            try {
                command.execute();
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
