package com.craft.command.library;

import com.craft.command.Command;
import com.craft.entity.LibraryEntity;
import com.craft.model.ResourceStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;


public class CreateLibraryCommand implements Command {

    private static final Logger logger = LoggerFactory.getLogger(CreateLibraryCommand.class);

    private final LibraryEntity libraryEntity;

    public CreateLibraryCommand(LibraryEntity libraryEntity) {
        this.libraryEntity = libraryEntity;
    }

    @Override
    public void execute() {
        String[] command = {
                "mvn",
                "archetype:generate",
                "-DarchetypeArtifactId=maven-archetype-quickstart",
                "-DinteractiveMode=false",
                "-DgroupId=com.craft."+libraryEntity.getLineOfBusiness(),
                "-DartifactId="+libraryEntity.getName()
        };

        // Define the directory in which to execute the command
        File workingDirectory = new File("./test-craft");

        // Create a ProcessBuilder instance
        ProcessBuilder processBuilder = new ProcessBuilder(command);
        processBuilder.directory(workingDirectory); // Set the working directory

        // Redirect error and output streams to the console
        processBuilder.redirectErrorStream(true);

        try {
            // Start the process
            Process process = processBuilder.start();

            // Read the output of the command
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            // Wait for the process to complete
            int exitCode = process.waitFor();
            System.out.println("Command executed with exit code: " + exitCode);
            libraryEntity.setStatus(ResourceStatus.CREATED);
            libraryEntity.setStatusDetails("Library created successfully.");
            libraryEntity.setVersion("1.0-SNAPSHOT");

        } catch (IOException | InterruptedException e) {
            logger.error("Command execution is failed: {}", e.getMessage());
            //e.printStackTrace();
            libraryEntity.setStatus(ResourceStatus.CREATION_FAILED);
            libraryEntity.setStatusDetails(e.getMessage());
        }
    }
}
