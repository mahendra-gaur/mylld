package com.craft.command.library;

import com.craft.command.Command;
import com.craft.command.CommandInvoker;
import com.craft.command.common.UploadGithubCommand;
import com.craft.entity.LibraryEntity;

import java.io.IOException;

public class LibraryCommandExecutor implements Command {

    private LibraryEntity libraryEntity;

    public LibraryCommandExecutor(LibraryEntity libraryEntity) {
        this.libraryEntity =libraryEntity;
    }

    @Override
    public void execute() throws IOException, InterruptedException {
        CommandInvoker invoker = new CommandInvoker();
        invoker.addCommand(new CreateLibraryCommand(libraryEntity)); // step-01 - create lib
        invoker.addCommand(new UploadGithubCommand(libraryEntity)); // step-02 - upload lib to github
        invoker.executeCommands();
    }
}
