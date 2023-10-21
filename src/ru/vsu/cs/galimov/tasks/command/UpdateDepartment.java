package ru.vsu.cs.galimov.tasks.command;

import ru.vsu.cs.galimov.tasks.model_objects.Department;
import ru.vsu.cs.galimov.tasks.service.ServiceDepartmentImplementation;

import java.text.SimpleDateFormat;
import java.util.Scanner;

public class UpdateDepartment extends Command{
    protected final ServiceDepartmentImplementation serviceDepartmentImplementation;

    public UpdateDepartment(Scanner scanner) {
        super(scanner);
        serviceDepartmentImplementation = ServiceDepartmentImplementation.getINSTANCE();
    }

    @Override
    public void runCommand() {
        try {
            System.out.print("Enter new dep id: ");
            int id = scanner.nextInt();
            System.out.print("Enter new dep name: ");
            String name = scanner.next();
            System.out.print("Enter new date: ");
            String workingHours = scanner.next();
            serviceDepartmentImplementation.renew(id, new Department(id, name, workingHours));

        } catch (Exception exception) {
            System.out.println("Illegal argument");
        }
    }

    @Override
    public String getCommandName() {
        return "UpdateDepartment";
    }
}
