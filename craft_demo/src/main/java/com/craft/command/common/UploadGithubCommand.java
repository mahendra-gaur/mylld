package com.craft.command.common;

import com.craft.command.Command;
import com.craft.command.library.CreateLibraryCommand;
import com.craft.entity.LibraryEntity;
import com.craft.entity.ResourceEntity;
import com.craft.model.ResourceStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class UploadGithubCommand implements Command {

    private static final Logger logger = LoggerFactory.getLogger(UploadGithubCommand.class);

    private final ResourceEntity resourceEntity;

    public UploadGithubCommand(ResourceEntity resourceEntity) {
        this.resourceEntity = resourceEntity;
    }

    @Override
    public void execute() {
        //TODO: upload artifact to github
        String codeRepo = "https://github.com/mahendra-gaur/craft-demo-testing/"+resourceEntity.getName();
        resourceEntity.setCodeRepository(codeRepo);
    }

}
