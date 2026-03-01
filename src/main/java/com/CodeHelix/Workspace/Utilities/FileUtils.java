package com.CodeHelix.Workspace.Utilities;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class FileUtils {

    public static void copyFolder(Path source , Path target) throws IOException{

        Files.walkFileTree(source, new SimpleFileVisitor<>(){

            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                Path targetDir = target.resolve(source.relativize(dir));

                if(!Files.exists(targetDir)){
                    Files.createDirectory(targetDir);
                }

                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                Files.copy(file , target.resolve(source.relativize(file)) , StandardCopyOption.REPLACE_EXISTING);

                return FileVisitResult.CONTINUE;
            }
        });
    }

    public static void createFolder(Path folder)throws IOException{
        if(!Files.exists(folder)){
            Files.createDirectories(folder);
        }
    }
}
