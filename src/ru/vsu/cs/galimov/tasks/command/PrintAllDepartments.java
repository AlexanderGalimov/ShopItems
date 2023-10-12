package ru.vsu.cs.galimov.tasks.command;

import ru.vsu.cs.galimov.tasks.controller.Controller;
import ru.vsu.cs.galimov.tasks.model_objects.Department;

import java.util.List;
import java.util.Scanner;

public class PrintAllDepartments extends Command{
    public PrintAllDepartments(Scanner scanner, Controller controller) {
        super(scanner, controller);
    }

    @Override
    public void runCommand() {
        List<Department> deps = controller.getAllDepartments();
        for (Department dep : deps) {
            System.out.println(dep);
        }
    }

    @Override
    public String getCommandName() {
        return "PrintAllDepartments";
    }
}
