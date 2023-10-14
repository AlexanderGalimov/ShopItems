package ru.vsu.cs.galimov.tasks.command;

import ru.vsu.cs.galimov.tasks.model_objects.Department;
import ru.vsu.cs.galimov.tasks.service.ServiceDepartmentImplementation;

import java.text.SimpleDateFormat;
import java.util.Scanner;

public class CreateDepartment extends Command{
    protected final ServiceDepartmentImplementation serviceDepartmentImplementation;
    public CreateDepartment(Scanner scanner) {
        super(scanner);
        serviceDepartmentImplementation = ServiceDepartmentImplementation.getINSTANCE();
    }

    @Override
    public void runCommand() {
        try {
            System.out.print("Enter name: ");
            String name = scanner.next();
            System.out.print("Enter date: ");
            String workingHours = scanner.next();
            // 31/12/1998
            serviceDepartmentImplementation.add(new Department(name, new SimpleDateFormat("dd/MM/yyyy").parse(workingHours)));

        } catch (Exception exception) {
            System.out.println("Illegal argument");
        }
    }

    @Override
    public String getCommandName() {
        return "Create Department";
    }
}