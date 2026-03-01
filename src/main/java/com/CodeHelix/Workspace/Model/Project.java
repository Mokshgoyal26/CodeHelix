package com.CodeHelix.Workspace.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.nio.file.Path;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Project {
    private String name;
    private Path sourcePath;
    private String origin;

}
