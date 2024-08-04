package com.craft.command.library;

import com.craft.command.Command;
import com.craft.entity.LibraryEntity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CreateLibraryCommand implements Command {

    private LibraryEntity libraryEntity;

    public CreateLibraryCommand(LibraryEntity libraryEntity) {
        this.libraryEntity = libraryEntity;
    }

    @Override
    public void execute() throws IOException, InterruptedException {
        ProcessBuilder processBuilder = new ProcessBuilder();
        processBuilder.command("bash", "-c",
                "mvn archetype:generate -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false "+
                        "-DgroupId=com.craft."+libraryEntity.getLineOfBusiness()+" -DartifactId="+libraryEntity.getName()+" ");

        Process process = processBuilder.start();
        int exitCode = process.waitFor();
        if (exitCode == 0) {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            }
        } else {
            System.out.println("Error occurred while generating lib artifacts.");
        }
    }
}
