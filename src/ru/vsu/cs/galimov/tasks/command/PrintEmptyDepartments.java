package ru.vsu.cs.galimov.tasks.command;

import ru.vsu.cs.galimov.tasks.controller.Controller;
import ru.vsu.cs.galimov.tasks.model_objects.Department;

import java.util.Scanner;

public class PrintEmptyDepartments extends Command{
    public PrintEmptyDepartments(Scanner scanner, Controller controller) {
        super(scanner, controller);
    }

    @Override
    public void runCommand() {
        for (Department department : controller.findEmptyDepartments()) {
            System.out.println(department);
        }
    }

    @Override
    public String getCommandName() {
        return "FindEmptyDepartments";
    }
}
