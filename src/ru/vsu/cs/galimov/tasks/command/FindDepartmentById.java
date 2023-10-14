package ru.vsu.cs.galimov.tasks.command;

import ru.vsu.cs.galimov.tasks.service.ServiceDepartmentImplementation;

import java.util.Scanner;

public class FindDepartmentById extends Command {
    protected final ServiceDepartmentImplementation serviceDepartmentImplementation;

    public FindDepartmentById(Scanner scanner) {
        super(scanner);
        serviceDepartmentImplementation = ServiceDepartmentImplementation.getINSTANCE();
    }

    @Override
    public void runCommand() {
        System.out.print("Enter id dep: ");
        int id = scanner.nextInt();
        serviceDepartmentImplementation.findById(id);
    }

    @Override
    public String getCommandName() {
        return "Find Department by ID";
    }
}

