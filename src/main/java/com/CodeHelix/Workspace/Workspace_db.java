package com.CodeHelix.Workspace;

import com.CodeHelix.Workspace.Model.Project;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.Getter;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Workspace_db {
    private static final String DB_PATH = "workspace/workspace_db.json";
    @Getter
    private final List<Project> projects = new ArrayList<>();
    private final ObjectMapper mapper;

    public Workspace_db(){
        mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
    }

    public void load() throws IOException{
        File db_file = new File(DB_PATH);

        if(db_file.exists()){
            List<Project> loaded = mapper.readValue(
                    db_file,
                    mapper.getTypeFactory().constructCollectionType(List.class , Project.class)
            );

            projects.clear();
            projects.addAll(loaded);

            System.out.println("Workspace_DB is loaded...");
        }
    }

    public void save() throws IOException {
        File file = new File(DB_PATH);

        file.getParentFile().mkdirs();

        mapper.writeValue(file,projects);
    }

    public void addProject(Project project){
        projects.add(project);
    }
}
