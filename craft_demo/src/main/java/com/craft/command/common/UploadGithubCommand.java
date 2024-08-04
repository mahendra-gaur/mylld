package com.craft.command.common;

import com.craft.command.Command;
import com.craft.entity.LibraryEntity;
import com.craft.entity.ResourceEntity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UploadGithubCommand implements Command {

    private ResourceEntity resourceEntity;

    public UploadGithubCommand(ResourceEntity resourceEntity) {
        this.resourceEntity = resourceEntity;
    }

    @Override
    public void execute() throws IOException, InterruptedException {
        //TODO: upload to github and update URL in resource entity
        resourceEntity.setCodeRepository("setPathToCodeRepo");
    }
}
