package ru.vsu.cs.galimov.tasks.command;

import ru.vsu.cs.galimov.tasks.model_objects.Product;
import ru.vsu.cs.galimov.tasks.service.ServiceProductImplementation;

import java.util.Scanner;

public class PrintAllProductInDepartment extends Command{
    protected final ServiceProductImplementation serviceProductImplementation;

    public PrintAllProductInDepartment(Scanner scanner) {
        super(scanner);
        serviceProductImplementation = ServiceProductImplementation.getINSTANCE();
    }

    @Override
    public void runCommand() {
        System.out.print("Enter dep id: ");
        int id = scanner.nextInt();

        for (Product product : serviceProductImplementation.allProductInDepartment(id)) {
            System.out.println(product);
        }
    }

    @Override
    public String getCommandName() {
        return "PrintAllProductInDepartment";
    }
}
