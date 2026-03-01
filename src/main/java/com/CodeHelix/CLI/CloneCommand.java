package com.CodeHelix.CLI;

import com.CodeHelix.Workspace.WorkspaceManager;
import picocli.CommandLine;

@CommandLine.Command(name = "clone" , description = "clone a git repository")
public class CloneCommand implements Runnable{

    @CommandLine.Parameters(index = "0" , description = "project name ")
    private String projectName;

    @CommandLine.Parameters(index = "1" , description = "Repository URL")
    private String repoUrl;

    @CommandLine.Parameters(index = "2" , defaultValue = "main",description = "Branch")
    private String branch;

    @Override
    public void run(){
        try{
            WorkspaceManager manager = new WorkspaceManager();
            manager.cloneGithubProject(projectName , repoUrl , branch);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
