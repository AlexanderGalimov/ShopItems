package ru.vsu.cs.galimov.tasks.command;

import ru.vsu.cs.galimov.tasks.model_objects.Department;
import ru.vsu.cs.galimov.tasks.service.ServiceDepartmentImplementation;
import ru.vsu.cs.galimov.tasks.service.ServiceProductImplementation;

import java.util.List;
import java.util.Scanner;

public class PrintAllDepartments extends Command{
    protected final ServiceDepartmentImplementation serviceDepartmentImplementation;

    public PrintAllDepartments(Scanner scanner) {
        super(scanner);
        serviceDepartmentImplementation = ServiceDepartmentImplementation.getINSTANCE();
    }

    @Override
    public void runCommand() {
        List<Department> deps = serviceDepartmentImplementation.getAll();
        for (Department dep : deps) {
            System.out.println(dep);
        }
    }

    @Override
    public String getCommandName() {
        return "PrintAllDepartments";
    }
}
