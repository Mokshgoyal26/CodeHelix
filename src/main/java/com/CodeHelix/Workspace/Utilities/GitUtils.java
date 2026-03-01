package com.CodeHelix.Workspace.Utilities;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;

import java.io.IOException;
import java.nio.file.Path;

public class GitUtils {

    public static void cloneRepo(String repoUrl , Path destination) throws GitAPIException {
            try(Git git = Git.cloneRepository()
                    .setURI(repoUrl)
                    .setDirectory(destination.toFile())
                    .call()){
            };


    }


    public static void pullChanges(Path repoPath , String branch)throws IOException , GitAPIException{
        try(Git git = Git.open(repoPath.toFile())){
            git.checkout().setName(branch).call();
            git.pull().call();
        }
    }
}
