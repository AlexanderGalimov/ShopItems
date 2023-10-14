package ru.vsu.cs.galimov.tasks.command;

import ru.vsu.cs.galimov.tasks.model_objects.Department;
import ru.vsu.cs.galimov.tasks.service.ServiceDepartmentImplementation;

import java.util.Scanner;

public class PrintEmptyDepartments extends Command{
    protected final ServiceDepartmentImplementation serviceDepartmentImplementation;

    public PrintEmptyDepartments(Scanner scanner) {
        super(scanner);
        serviceDepartmentImplementation = ServiceDepartmentImplementation.getINSTANCE();
    }

    @Override
    public void runCommand() {
        for (Department department : serviceDepartmentImplementation.findEmptyDepartments()) {
            System.out.println(department);
        }
    }

    @Override
    public String getCommandName() {
        return "FindEmptyDepartments";
    }
}
