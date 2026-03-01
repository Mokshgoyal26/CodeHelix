package com.CodeHelix.Workspace.Model;

import com.CodeHelix.Workspace.Utilities.GitUtils;
import lombok.*;
import org.eclipse.jgit.api.errors.GitAPIException;

import java.io.IOException;
import java.nio.file.Path;


public class GithubProject extends Project{

    @Getter
    private final String repoUrl;
    @Getter @Setter
    private String branch;
    @Setter @Getter
    private String lastCommit;

    public GithubProject(String name , Path sourcePath , String repoUrl , String branch){
        super(name , sourcePath , "github");
        this.repoUrl = repoUrl;
        this.branch = branch;
    }


    public void sync()throws IOException , GitAPIException {
        GitUtils.pullChanges(getSourcePath() , branch);
        System.out.println("Github Project : "+ getName() + "Synced with Branch : "+branch);

    }
}
