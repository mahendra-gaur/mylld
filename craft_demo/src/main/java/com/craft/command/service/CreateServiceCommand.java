package com.craft.command.service;

import com.craft.command.Command;
import com.craft.model.LibraryRequest;

import java.io.IOException;

public class CreateServiceCommand implements Command {

    private LibraryRequest libraryRequest;  //TODO: chagne to service object

    public CreateServiceCommand(LibraryRequest libraryRequest) {
        this.libraryRequest = libraryRequest;
    }//TODO: chagne to service object

    @Override
    public void execute() throws IOException, InterruptedException {
        //TODO:
    }
}
