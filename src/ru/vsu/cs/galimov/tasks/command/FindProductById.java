package ru.vsu.cs.galimov.tasks.command;

import ru.vsu.cs.galimov.tasks.service.ServiceProductImplementation;

import java.util.Scanner;

public class FindProductById extends Command {
    protected final ServiceProductImplementation serviceProductImplementation;

    public FindProductById(Scanner scanner) {
        super(scanner);
        serviceProductImplementation = ServiceProductImplementation.getINSTANCE();
    }

    @Override
    public void runCommand() {
        System.out.print("Enter id product: ");
        int id = scanner.nextInt();
        System.out.println(serviceProductImplementation.findById(id));
    }

    @Override
    public String getCommandName() {
        return "Find product by id";
    }
}
