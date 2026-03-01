package com.CodeHelix.Workspace;

import com.CodeHelix.Workspace.Model.GithubProject;
import com.CodeHelix.Workspace.Model.LocalProject;
import com.CodeHelix.Workspace.Model.Project;
import com.CodeHelix.Workspace.Utilities.FileUtils;
import com.CodeHelix.Workspace.Utilities.GitUtils;
import org.eclipse.jgit.api.errors.GitAPIException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class WorkspaceManager {
    private final Path workspaceRoot = Paths.get("workspace/projects");
    private final Workspace_db workspaceDB = new Workspace_db();

    public WorkspaceManager() throws IOException {
        FileUtils.createFolder(workspaceRoot);
        workspaceDB.load();
    }

    public void importLocalProject(String projectName , String localPath) throws IOException{
        Path projectPath = workspaceRoot.resolve(projectName).resolve("src");
        FileUtils.createFolder(projectPath);
        FileUtils.copyFolder(Paths.get(localPath) , projectPath);

        LocalProject localProject = new LocalProject(projectName , projectPath);

        workspaceDB.addProject(localProject);
        workspaceDB.save();

        System.out.println("local Project Imported ... : "+ projectName);
    }

    public void cloneGithubProject(String projectName , String repoUrl , String branch) throws IOException , GitAPIException {
        Path projectPath = workspaceRoot.resolve(projectName).resolve("src");
        FileUtils.createFolder(projectPath);

        GitUtils.cloneRepo(repoUrl , projectPath);

        GithubProject gitProject = new GithubProject(projectName , projectPath , repoUrl , branch);

        workspaceDB.addProject(gitProject);
        workspaceDB.save();
        System.out.println("Git project Cloned ... : "+ projectName);

    }

    public List<Project> getProjects(){
        return workspaceDB.getProjects();
    }
}
