package com.CodeHelix.CLI;

import com.CodeHelix.Workspace.WorkspaceManager;
import picocli.CommandLine;

@CommandLine.Command(name = "list" , description = "List all Projects")
public class ListCommand implements Runnable{

    @Override
    public void run(){

        try{
            WorkspaceManager manager = new WorkspaceManager();
            manager.getProjects()
                    .forEach(p -> System.out.println("-- " + p.getName()));

            System.out.println("Total Projects : "+manager.getProjects().size());

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
