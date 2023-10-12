package ru.vsu.cs.galimov.tasks.command;

import ru.vsu.cs.galimov.tasks.controller.Controller;

import java.util.Scanner;

public class DeleteProduct extends Command{
    public DeleteProduct(Scanner scanner, Controller controller) {
        super(scanner, controller);
    }

    @Override
    public void runCommand() {
        System.out.print("Enter id prod to del: ");
        int id = scanner.nextInt();

        controller.deleteProduct(id);
    }

    @Override
    public String getCommandName() {
        return "DeleteProduct";
    }
}
