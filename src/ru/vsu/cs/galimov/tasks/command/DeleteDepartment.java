package ru.vsu.cs.galimov.tasks.command;

import ru.vsu.cs.galimov.tasks.service.ServiceDepartmentImplementation;

import java.util.Scanner;

public class DeleteDepartment extends Command{
    protected final ServiceDepartmentImplementation serviceDepartmentImplementation;
    public DeleteDepartment(Scanner scanner) {
        super(scanner);
        serviceDepartmentImplementation = ServiceDepartmentImplementation.getINSTANCE();
    }

    @Override
    public void runCommand() {
        System.out.print("Enter id dep for del: ");
        int id = scanner.nextInt();
        serviceDepartmentImplementation.delete(id);
    }

    @Override
    public String getCommandName() {
        return "DeleteDepartment";
    }
}
