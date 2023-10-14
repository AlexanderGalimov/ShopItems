package ru.vsu.cs.galimov.tasks.command;

import ru.vsu.cs.galimov.tasks.service.ServiceProductImplementation;

import java.util.Scanner;

public class DeleteProduct extends Command{
    protected final ServiceProductImplementation serviceProductImplementation;
    public DeleteProduct(Scanner scanner) {
        super(scanner);
        serviceProductImplementation = ServiceProductImplementation.getINSTANCE();
    }

    @Override
    public void runCommand() {
        System.out.print("Enter id prod to del: ");
        int id = scanner.nextInt();

        serviceProductImplementation.delete(id);
    }

    @Override
    public String getCommandName() {
        return "DeleteProduct";
    }
}
