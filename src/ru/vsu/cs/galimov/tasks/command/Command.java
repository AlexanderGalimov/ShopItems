package ru.vsu.cs.galimov.tasks.command;

import ru.vsu.cs.galimov.tasks.controller.Controller;

import java.util.Scanner;

public abstract class Command {
    protected final Scanner scanner;
    protected Controller controller;

    public Command(Scanner scanner, Controller controller){
        this.scanner = scanner;
        this.controller = Controller.getINSTANCE();
    }

    public abstract void runCommand();

    public abstract String getCommandName();
}
