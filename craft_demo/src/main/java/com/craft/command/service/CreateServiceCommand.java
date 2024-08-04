package com.craft.command.service;

import com.craft.command.Command;
import com.craft.model.Library;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CreateServiceCommand implements Command {

    private Library library;  //TODO: chagne to service object

    public CreateServiceCommand(Library library) {
        this.library = library;
    }//TODO: chagne to service object

    @Override
    public void execute() throws IOException, InterruptedException {
        //TODO:
    }
}
