package ru.vsu.cs.galimov.tasks.command;

import ru.vsu.cs.galimov.tasks.controller.Controller;
import ru.vsu.cs.galimov.tasks.model_objects.Department;

import java.text.SimpleDateFormat;
import java.util.Scanner;

public class CreateDepartment extends Command{
    public CreateDepartment(Scanner scanner, Controller controller) {
        super(scanner, controller);
    }

    @Override
    public void runCommand() {
        try {
            System.out.print("Enter name: ");
            String name = scanner.next();
            System.out.print("Enter date: ");
            String workingHours = scanner.next();
            // 31/12/1998
            controller.addDepartment(new Department(name, new SimpleDateFormat("dd/MM/yyyy").parse(workingHours)));

        } catch (Exception exception) {
            System.out.println("Illegal argument");
        }
    }

    @Override
    public String getCommandName() {
        return "Create Department";
    }
}
