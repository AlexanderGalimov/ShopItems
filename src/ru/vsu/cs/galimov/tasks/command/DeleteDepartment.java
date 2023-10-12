package ru.vsu.cs.galimov.tasks.command;

import ru.vsu.cs.galimov.tasks.controller.Controller;

import java.util.Scanner;

public class DeleteDepartment extends Command{
    public DeleteDepartment(Scanner scanner, Controller controller) {
        super(scanner, controller);
    }

    @Override
    public void runCommand() {
        System.out.print("Enter id dep for del: ");
        int id = scanner.nextInt();

        controller.deleteDepartment(id);
    }

    @Override
    public String getCommandName() {
        return "DeleteDepartment";
    }
}
