package ru.vsu.cs.galimov.tasks.command;

import java.util.Scanner;

public abstract class Command {
    protected final Scanner scanner;

    public Command(Scanner scanner){
        this.scanner = scanner;
    }

    public abstract void runCommand();

    public abstract String getCommandName();
}
