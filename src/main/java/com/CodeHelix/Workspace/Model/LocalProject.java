package com.CodeHelix.Workspace.Model;

import java.nio.file.Path;

public class LocalProject extends Project{

    public LocalProject(String name , Path sourcePath){
        super(name, sourcePath , "local");
    }


    public void sync(){
        System.out.println("local project sync : nothing to pull");
    }

}
