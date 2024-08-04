package com.craft;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.transport.URIish;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;
import org.eclipse.jgit.transport.RefSpec;

import java.io.File;

public class GithubUploadTest {

    final static String REMOTE_URL = "https://github.com/mahendra-gaur/craft-demo-testing.git"; // Replace with your remote URL
    final static String USERNAME = "mahendra-gaur"; // Replace with your GitHub username
    final static String PASSWORD = ""; // Replace with your GitHub password or personal access token

    public static void main(String[] args) {
        String localPath = "/Users/deepakvishwakarma/mylld/craft_demo/craft_resources";
        initializeRepository(localPath);
        pushChanges(localPath);

    }
    public static void initializeRepository(String localPath) {
        try {
            Git git = Git.init().setDirectory(new File(localPath)).call();
            System.out.println("Repository initialized at: " + localPath);
        } catch (GitAPIException e) {
            e.printStackTrace();
        }
    }

    public static void pushChanges(String localPath) {
        try (Git git = Git.open(new File(localPath))) {
            git.add().addFilepattern(".").call(); // Add all files
            git.commit().setMessage("Initial commit").call();

            git.remoteAdd().setName("origin").setUri(new URIish(REMOTE_URL)).call();
            git.push()
                    .setCredentialsProvider(new UsernamePasswordCredentialsProvider(USERNAME, PASSWORD))
                    .setRefSpecs(new RefSpec("refs/heads/master:refs/heads/master"))
                    .call();

            System.out.println("Pushed changes to remote repository.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
