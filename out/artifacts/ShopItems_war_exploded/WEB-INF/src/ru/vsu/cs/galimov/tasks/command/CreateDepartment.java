package ru.vsu.cs.galimov.tasks.command;

import ru.vsu.cs.galimov.tasks.model_objects.Department;
import ru.vsu.cs.galimov.tasks.service.ServiceDepartmentImplementation;

import java.util.Scanner;

public class CreateDepartment extends Command {
    protected final ServiceDepartmentImplementation serviceDepartmentImplementation;

    public CreateDepartment(Scanner scanner) {
        super(scanner);
        serviceDepartmentImplementation = ServiceDepartmentImplementation.getINSTANCE();
    }

    @Override
    public void runCommand() {
        try {
            System.out.println("Enter name: ");
            String name = scanner.next();
            System.out.println("Enter working hours: ");
            String workingHours = scanner.next();
            serviceDepartmentImplementation.add(new Department(name, workingHours));

        } catch (Exception exception) {
            System.out.println("Illegal argument");
        }
    }

    @Override
    public String getCommandName() {
        return "Create Department";
    }
}
