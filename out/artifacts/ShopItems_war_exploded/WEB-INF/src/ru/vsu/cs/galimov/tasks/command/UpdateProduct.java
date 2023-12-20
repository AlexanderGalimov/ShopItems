package ru.vsu.cs.galimov.tasks.command;

import ru.vsu.cs.galimov.tasks.model_objects.Product;
import ru.vsu.cs.galimov.tasks.service.ServiceProductImplementation;

import java.util.Scanner;

public class UpdateProduct extends Command{
    protected final ServiceProductImplementation serviceProductImplementation;

    public UpdateProduct(Scanner scanner) {
        super(scanner);
        serviceProductImplementation = ServiceProductImplementation.getINSTANCE();
    }

    @Override
    public void runCommand() {
        System.out.print("Enter new product id: ");
        int id = scanner.nextInt();
        System.out.print("Enter new product name: ");
        String name = scanner.next();
        System.out.print("Enter price: ");
        double price = scanner.nextDouble();
        System.out.print("Enter dep id: ");
        int idDepartment = scanner.nextInt();

        serviceProductImplementation.renew(id, new Product(id, name, price, idDepartment));
    }

    @Override
    public String getCommandName() {
        return "Update product";
    }
}
