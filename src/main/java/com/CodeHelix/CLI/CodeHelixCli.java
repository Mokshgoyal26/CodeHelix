package com.CodeHelix.CLI;

import picocli.CommandLine;

@CommandLine.Command(
        name = "ch",
        mixinStandardHelpOptions = true,
        version = "1.0",
        description = "CodeHelix Cli",
        subcommands = {
                ImportCommand.class,
                CloneCommand.class,
                ListCommand.class
        }
)
public class CodeHelixCli implements Runnable{

    @Override
    public void run(){
        System.out.println("Use --help to see available commands");
    }

    public static void main(String[] args){
        int exitCode = new CommandLine(new CodeHelixCli()).execute(args);
        System.exit(exitCode);
    }

}
