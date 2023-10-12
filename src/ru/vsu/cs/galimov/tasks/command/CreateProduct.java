package ru.vsu.cs.galimov.tasks.command;

import ru.vsu.cs.galimov.tasks.controller.Controller;
import ru.vsu.cs.galimov.tasks.model_objects.Product;

import java.util.Scanner;

public class CreateProduct extends Command{

    public CreateProduct(Scanner scanner, Controller controller) {
        super(scanner, controller);
    }

    @Override
    public void runCommand() {
        System.out.print("Enter product name: ");
        String name = scanner.next();
        System.out.print("Enter price: ");
        double price = scanner.nextDouble();
        System.out.print("Enter department id: ");
        int idDepartment = scanner.nextInt();

        controller.addProduct(new Product(name, price, idDepartment));
    }

    @Override
    public String getCommandName() {
        return "Create Product";
    }
}
