package ru.vsu.cs.galimov.tasks.command;

import ru.vsu.cs.galimov.tasks.model_objects.Product;
import ru.vsu.cs.galimov.tasks.service.ServiceProductImplementation;

import java.util.Scanner;

public class CreateProduct extends Command{
    protected final ServiceProductImplementation serviceProductImplementation;

    public CreateProduct(Scanner scanner) {
        super(scanner);
        serviceProductImplementation = ServiceProductImplementation.getINSTANCE();
    }

    @Override
    public void runCommand() {
        System.out.print("Enter product name: ");
        String name = scanner.next();
        System.out.print("Enter price: ");
        double price = scanner.nextDouble();
        System.out.print("Enter department id: ");
        int idDepartment = scanner.nextInt();

        serviceProductImplementation.add(new Product(name, price, idDepartment));
    }

    @Override
    public String getCommandName() {
        return "Create Product";
    }
}
