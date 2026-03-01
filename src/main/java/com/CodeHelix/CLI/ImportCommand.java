package com.CodeHelix.CLI;

import com.CodeHelix.Workspace.WorkspaceManager;
import picocli.CommandLine;

@CommandLine.Command(name = "import" , description = "import command for local project")
public class ImportCommand implements Runnable{

    @CommandLine.Parameters(index = "0" , description = "project name")
    private String projectName;

    @CommandLine.Parameters(index = "1" ,description = "local project path")
    private String localPath;

    @Override
    public void run(){
        try{
            WorkspaceManager manager = new WorkspaceManager();
            manager.importLocalProject(projectName , localPath);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
